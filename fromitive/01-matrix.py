"""
title : 01 Matrix
link  : https://leetcode.com/problems/01-matrix

description

m x n 의 mat 행렬이 주어진다. 원소의 값은 0 혹은 1로 구성되어 있는데 각 원소별로 제일 가까운 0의 거리를 구한다.

해결 방안

BFS를 활용하면 큐에 있는 점들을 동시에 탐색이 가능하다. 1에서 0으로 도달하는 것과 0에서 1로 도달하는 것이 동일한 점을 이용한다.
"""

class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        queue = deque()
        seen = set()
        for row in range(len(mat)):
            for col in range(len(mat[row])):
                if mat[row][col] == 0:
                    queue.append((row, col, 1))
                    seen.add((row, col))
        
        def isValid(row, col):
            return 0 <= row < len(mat) and 0 <= col < len(mat[row])
        
        directions = [(0, -1), (0, 1), (1, 0), (-1, 0)]
        while queue:
            row, col, step = queue.popleft()
            for dy, dx in directions:
                nextRow = row + dy
                nextCol = col + dx
                if (nextRow, nextCol) not in seen and isValid(nextRow, nextCol):
                    seen.add((nextRow, nextCol))
                    queue.append((nextRow, nextCol, step + 1))
                    mat[nextRow][nextCol] = step
        return mat
