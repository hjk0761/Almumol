"""
title : Find if Path Exists in Graph
link  : https://leetcode.com/problems/find-if-path-exists-in-graph

description

노드 개수 n인 graph 정보가 주어진다. edges에는 양방향 direction정보가 주어지는데 각 원소는 [x, y] 형태로 구성되어 있다. 
[x, y] 는 x 에서 y로 갈 수 있으며 y 또한 x로 갈 수 있다는 의미이다.
이때, source와 destination정보자 주어졌을 때 도달 가능 여부를 구하는 코드를 작성한다.
"""

from collections import defaultdict
class Solution:
    def validPath(self, n: int, edges: List[List[int]], source: int, destination: int) -> bool:
        graph = defaultdict(list)
        for x, y in edges:
            graph[x].append(y)
            graph[y].append(x)
        seen = set()
        stack = [source]
        while stack:
            node = stack.pop()
            if destination == node:
                return True
            for neighbor in graph[node]:
                if neighbor not in seen:
                    seen.add(neighbor)
                    stack.append(neighbor)
        return False

