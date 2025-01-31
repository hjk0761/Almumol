"""
title : Evaluate Division
link  : https://leetcode.com/problems/evaluate-division

description

같은 길이의 배열 equations와 values가 주어진다. 한 원소 equeations[i]는 values[i]와 대응된다.
equations 원소 형태는 [x, y] 이며 이는 x / y = values[i]를 의미한다.
이때 queries에 있는 값들을 저장하는 answer를 구해야 한다. 단, 각 query의 값을 찾지 못할 경우 -1.0을 저장한다.

해결 방안
""" 

from collections import defaultdict
class Solution:
    def calcEquation(self, equations: List[List[str]], values: List[float], queries: List[List[str]]) -> List[float]:
        graph = defaultdict(list)
        for i in range(len(equations)):
            x = equations[i][0]
            y = equations[i][1]
            graph[x].append((y, values[i]))
            graph[y].append((x, 1.0 / values[i]))
        answer = [-1.0] * len(queries)

        def dfs(start, end):
            seen = set()
            stack = [(start, 1.0)]
            seen.add(start)
            while stack:
                node, value = stack.pop()
                if node == end:
                    return value
                for neighbor, nextValue in graph[node]:
                    if neighbor not in seen:
                        seen.add(neighbor)
                        stack.append([neighbor, value * nextValue])
            return -1.0

        for i in range(len(queries)):
            start, end = queries[i]
            if start in graph:
                result = dfs(start,end)
                answer[i] = result
        return answer 
