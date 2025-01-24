""" 
title : Number of Connected Components in an Undirected Graph
link  : https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph

description

connected components 의 개수를 구하는 문제이다. number of provinces 문제와 동일하다.

"""

from collections import defaultdict
class Solution:
    def countComponents(self, n: int, edges: List[List[int]]) -> int:
        graph = defaultdict(list)
        for x, y in edges:
            graph[x].append(y)
            graph[y].append(x)
        
        
        seen = set()

        def dfs(start):
            nonlocal seen
            stack = [start]
            while stack:
                node = stack.pop()
                for neighbor in graph[node]:
                    if neighbor not in seen:
                        seen.add(neighbor)
                        stack.append(neighbor)
            
        answer = 0
        for node in range(n):
            if node not in seen:
                answer += 1
                seen.add(node)
                dfs(node)
    
        return answer
