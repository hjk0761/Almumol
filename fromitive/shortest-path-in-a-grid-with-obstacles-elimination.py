"""
title : Shortest Path in a Grid with Obstacles Elimination
link  : https://leetcode.com/problems/shortest-path-in-a-grid-with-obstacles-elimination

description
n * n grid가 주어질 때 grid[0][0]에서 grid[n - 1][n - 1]까지 갈 수 있는 최단 경로를 구하라 단 0은 갈 수 있는 길이고 1은 갈 수 없는 길이지만, k 횟수만큼 갈 수 없는 길을 갈 수 있다.

해결 방안
seen을 기록한다는 것은 "같은 상태"를 더이상 방문하지 않는다는 의미임을 잊지말자
"""

from collections import deque
class Solution:
    def shortestPath(self, grid: List[List[int]], k: int) -> int:
        m = len(grid)
        n = len(grid[0])
        queue = deque()
        queue.append((0, 0, k, 0))
        seen = set()
        seen.add((0, 0, k))
        directions = [(0, 1), (0, -1), (-1, 0), (1, 0)]

        def isValid(i, j):
            return 0 <= i < len(grid) and 0 <= j < len(grid[i])
        
        while queue:
            row, col, remain, step = queue.popleft()
            if (row, col) == (m - 1, n - 1):
                return step
            for dy, dx in directions:
                nextRow = row + dy
                nextCol = col + dx
                if  isValid(nextRow, nextCol) and grid[nextRow][nextCol] == 0 and (nextRow, nextCol, remain) not in seen:
                    queue.append((nextRow, nextCol, remain, step + 1))
                    seen.add((nextRow, nextCol, remain))
                elif isValid(nextRow, nextCol) and grid[nextRow][nextCol] == 1 and (nextRow, nextCol, remain - 1) not in seen and remain > 0:
                    queue.append((nextRow, nextCol, remain - 1, step + 1))
                    seen.add((nextRow, nextCol, remain - 1))
        return -1
