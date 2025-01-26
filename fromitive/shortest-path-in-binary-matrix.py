"""
title : Shortest Path in Binary Matrix
link  : https://leetcode.com/problems/shortest-path-in-binary-matrix

description
n * n grid가 주어질 때 grid[0][0]에서 grid[n - 1][n - 1]까지 갈 수 있는 최단 경로를 구하라
"""
from collections import deque

class Solution:
    def shortestPathBinaryMatrix(self, grid: List[List[int]]) -> int:
        def isValid(i, j):
            return (0 <= i < len(grid) and 0 <= j < len(grid[i]) and grid[i][j] == 0)
        if not isValid(0, 0):
            return -1
        n = len(grid)
        directions = [(0, 1), (0, -1), (1, 0), (-1, 0), (1, 1), (1, -1), (-1, 1), (-1, -1)]
        seen = set()
        queue = deque() 
        queue.append([0, 0, 1])
        while queue:
            row, col, steps = queue.popleft()
            if (row, col) == (n - 1, n - 1):
                return steps
            for dx, dy in directions:
                nextRow = row + dx
                nextCol = col + dy
                if (nextRow, nextCol) not in seen and isValid(nextRow, nextCol):
                    seen.add((nextRow, nextCol))
                    queue.append((nextRow, nextCol, steps + 1))
        
        return -1