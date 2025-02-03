""" 
title : Shortest Path with Alternating colors
link  : https://leetcode.com/problems/shortest-path-with-alternating-colors

description
n 개의 노드와 두 간선 정보인 redEdges, blueEdges가 [from, to] 형태로 주어진다. 
이때 각 노드의 번호를 x 라고 할 때 0 부터 x 까지의 최단 경로를 구해야 한다.
그리고 각 노드를 이동할 때 이전 노드에서 현재 노드까지 붉은 간선으로 이동했다면, 다음 노드로 이동할 땐 푸른 간선 정보를 활용해 이동해야만 한다.
반대로 이전 노드에서 현재 노드로 이동할 때 푸른 간선정보를 이용했다면 다음 노드로 이동할 땐 붉은 간선 정보를 활용해 이동해야만 한다.
"""

from collections import deque, defaultdict

class Solution:
    def shortestAlternatingPaths(self, n: int, redEdges: List[List[int]], blueEdges: List[List[int]]) -> List[int]:
        RED = 1
        BLUE = 0
        graph = defaultdict(lambda: defaultdict(list))
        for i, j in redEdges:
            graph[RED][i].append(j)

        for i, j in blueEdges:
            graph[BLUE][i].append(j)
        
        answer = [float("inf")] * n
        seen = set()
        seen.add((0, RED))
        seen.add((0, BLUE))
        queue = deque()
        queue.append([0, RED, 0])
        queue.append([0, BLUE, 0])
        while queue:
            node, color, step = queue.popleft()
            answer[node] = min(answer[node], step)
            for neighbor in graph[color][node]:
                if (neighbor, 1 - color) not in seen: # 1 - RED(1) = BLUE(0), 1 - BLUE(0) = RED(1)
                    queue.append([neighbor, 1 - color, step + 1])
                    seen.add((neighbor, 1 - color))

        return [ -1 if node == float('inf') else node for node in answer]
