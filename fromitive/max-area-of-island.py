"""
title : Max Area of Island
link  : https://leetcode.com/problems/max-area-of-island

description

m * n 의 맵 정보 grid가 주어진다. grid[i][j] == 1일경우 땅이 존재하는 것이고, grid[i][j] == 0 일 경우 물이 존재한다.
섬의 이동방향은 동서남북 4방향으로만 이동가능하다.
맵에 표현되어있는 섬중에 가장 면적이 큰 섬을 구한다.
"""

class Solution:
    def maxAreaOfIsland(self, grid: List[List[int]]) -> int:
        directions = [(0, 1), (0, -1), (1, 0), (-1, 0)]
        
        answer = 0
        def isValid(i, j):
            return (0 <= i < len(grid) and 0 <= j < len(grid[i]) and grid[i][j] == 1)
        
        seen = set()
        def getArea(i, j):
            area = 0
            stack = [(i, j)]
            while stack:
                i, j = stack.pop()
                area += 1
                for dx, dy in directions:
                    nextI = i + dx
                    nextJ = j + dy
                    if (nextI, nextJ) not in seen and isValid(nextI, nextJ):
                        seen.add((nextI, nextJ))
                        stack.append([nextI, nextJ])
            return area

        for i in range(len(grid)):
            for j in range(len(grid[i])):
                if (i, j) not in seen and isValid(i, j):
                    seen.add((i, j))
                    area = getArea(i ,j)
                    answer = max(answer, area)

        return answer
