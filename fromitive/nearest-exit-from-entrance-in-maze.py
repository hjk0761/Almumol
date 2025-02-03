"""
title : Nearest Exit from Entrance in Maze
link  : https://leetcode.com/problems/nearest-exit-from-entrance-in-maze

description
"""
from collections import deque
class Solution:
    def nearestExit(self, maze: List[List[str]], entrance: List[int]) -> int:
        def isBorder(row, col):
            return row == 0 or row == len(maze) - 1 or col == 0 or col == len(maze[row]) -1
        
        def isValid(row, col):
            return 0 <= row < len(maze) and 0 <= col < len(maze[row])
        
        if maze[entrance[0]][entrance[1]] == '+':
            return -1
        seen = set()
        seen.add((entrance[0], entrance[1]))
        queue = deque()
        queue.append((entrance[0], entrance[1], 0))
        directions = [(0, -1), (0, 1), (1, 0), (-1, 0)]
        
        while queue:
            row, col, step = queue.popleft()
            for dy, dx in directions:
                nextRow = row + dy
                nextCol = col + dx
                if (nextRow, nextCol) not in seen and isValid(nextRow, nextCol) and maze[nextRow][nextCol] == ".":
                    if isBorder(nextRow, nextCol):
                        return step + 1
                    seen.add((nextRow, nextCol))
                    queue.append((nextRow, nextCol, step + 1))
        return -1