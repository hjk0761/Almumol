"""
title: All Paths From Source to Target
link : https://leetcode.com/problems/all-paths-from-source-to-target

0 부터 n - 1개의 노드와 graphs 간선이 주어진다. 
graphs[i]는 i 노드에 대해 연결되어 있는 node들이 주어질 때 0 부터 n - 1 까지 도달 가능한 모든 경로를 구하자

해결 방안
bfs를 활용하면 최단 경로를 찾을 수 있지만, 모든 경로를 구하는 문제이기 때문에 백트레킹으로 중복없는 경로를 구한다.
가까이 이어저있는 Node에 방문한 뒤에 방문 정보와 경로 정보를 지우는 식으로 구현하면 된다!
"""

class Solution:
    def allPathsSourceTarget(self, graph: List[List[int]]) -> List[List[int]]:
        def backtrack(node, seen, path):
            if node == len(graph) - 1:
                answer.append(path[:])
                return

            for neighbor in graph[node]:
                if neighbor not in seen:
                    seen.add(neighbor)
                    path.append(neighbor)
                    backtrack(neighbor, seen, path)
                    seen.remove(neighbor)
                    path.pop()
        
        answer = []
        backtrack(0, {0}, [0])
        return 


## 간선정보는 양방향이 아니므로 seen을 제거할 수 있다.
class Solution:
    def allPathsSourceTarget(self, graph: List[List[int]]) -> List[List[int]]:
        def backtrack(node, path):
            if node == len(graph) - 1:
                answer.append(path[:])
                return

            for neighbor in graph[node]:
                path.append(neighbor)
                backtrack(neighbor, path)
                path.pop()
        
        answer = []
        backtrack(0, [0])
        return answer