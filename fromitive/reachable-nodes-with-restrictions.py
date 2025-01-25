"""
title : Reachable Nodes With Restrictions
link  : https://leetcode.com/problems/reachable-nodes-with-restrictions

description
그래프 간선정보인 edges, Node의 개수 n 그리고 접근 제한 정보인 restrictions가 주어진다.
이때 0부터 시작하여 도달할 수 있는 최대 노드의 개수를 구해야 한다. 단, restrictions에 등록된 node는 접근이 불가능하다.
"""

from collections import defaultdict
class Solution:
    def reachableNodes(self, n: int, edges: List[List[int]], restricted: List[int]) -> int:
        seen = set()
        for node in restricted:
            seen.add(node)
        
        graph = defaultdict(list)
        for start, end in edges:
            graph[start].append(end)
            graph[end].append(start)
        
        stack = [0]
        answer = 0
        seen.add(0)
        while stack:
            node = stack.pop()
            answer += 1
            for neighbor in graph[node]:
                if neighbor not in seen:
                    seen.add(neighbor)
                    stack.append(neighbor)
        return answer
