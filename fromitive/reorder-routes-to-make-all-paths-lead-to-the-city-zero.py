"""
title : Reorder Routes to Make All Paths Lead to the City Zero
link  : https://leetcode.com/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero

description
0 번부터 n - 1 번째 도시가 있고 각 도시의 연결 정보인 connection이 존재한다.
connection의 각 원소는 [start, end]형대로 되어있고 start 번째 도시에서 end 도시로만 이동이 가능하다 뜻이다. 
connection 정보가 주어질 때 0 번 도시로 향하도록 하도록 connection을 바꾸려면 몇 번 바꿔야 하는지 구해야 한다.

해결 방안
connection 정보는 directed graph 정보를 담고 있다. 이에 대한 정보를 unorder directed graph로 변경하자.
그래프 탐색을 0 부터 시작하면 0번으로 부터 뻗어나가는 방향이 보장된다.
그래프 노드를 탐색할 때마다 [현재 노드, 다음노드] 정보가 connection 안에 들어 있으면 변경이 필요한 정보이므로 이때 개수를 샌다.
"""
from collections import deque

class Solution:
    def minReorder(self, n: int, connections: List[List[int]]) -> int:
            graph = defaultdict(list)
            roads = set()
            for start, end in connections:
                graph[start].append(end)
                graph[end].append(start)
                roads.add((start, end))
            
            stack = [0]
            seen = {0}
            answer = 0
            while stack:
                node = stack.pop()
                for neighbor in graph[node]:
                    if neighbor not in seen:
                        if (node, neighbor) in roads:
                            answer += 1
                        seen.add(neighbor)
                        stack.append(neighbor)

            return answer