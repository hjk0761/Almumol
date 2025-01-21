""" 
title : Number of Islands
link  : https://leetcode.com/problems/number-of-islands

description

m * n 크기의 2차원 배열이 있다. 해당 배열에는 섬 정보가 저장되어 있는데 1은 땅 0은 물이다.

해당 맵의 섬의 개수를 구해야 한다. 

해결 방안

갈수있는 방향과 방문지점을 저장해야 한다. 시간복잡도는 O(node + edge) , 공간복잡도는 O(m * n)이 든다.
"""

from collections import deque
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        moveMent = [[0,1],[1,0],[0,-1],[-1,0]]
        queue = deque()
        seen = [[0] * len(row) for row in grid]
        answer = 0

        def isvalid(row, column):
            return (0 <= row < len(grid) and 
                    0 <= column < len(grid[row]) and
                    seen[row][column] == 0 and
                    grid[row][column] == "1")
            
        def bfs(row, column):
            queue = deque()
            queue.append([row,column])
            while queue:    
                row, column = queue.popleft()
                for rowStep, columnStep in moveMent:
                    nextRow = row + rowStep
                    nextColumn = column + columnStep
                    if isvalid(nextRow, nextColumn):
                        seen[nextRow][nextColumn] = 1
                        queue.append([nextRow,nextColumn])
                    
        for row in range(len(grid)):
            for column in range(len(grid[row])):
                if isvalid(row, column):
                    seen[row][column] = 1
                    bfs(row,column)
                    answer += 1 
                    
        return answer
            