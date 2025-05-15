""" 
title: Minimum Falling Path Sum
link : https://leetcode.com/problems/minimum-falling-path-sum

description

m * n matrix 하나 주어진다. 각 원소는 정수가 저장되어 있다.
첫번째 행의 원소 중 한개를 선택하고 이동할 수 있는 바향이 대각 또는 아래일 때 마지막 행에 도달하기 까지 원소들의 합의 최소 값을 구해야 한다.
"""
class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        rows = len(matrix)
        cols = len(matrix[0])
        
        dp = [[0] * cols for _ in range(rows)]
        for col in range(cols):
            dp[0][col] = matrix[0][col]
        def isValid(row, col):
            return 0 <= row < rows and 0 <= col < cols
        
        directions = [(-1, -1), (-1, 1)]
        for row in range(rows):
            for col in range(cols):
                dp[row][col] = matrix[row][col]
                if row > 0:
                    minPath = dp[row - 1][col]
                    for dy, dx in directions:
                        prevRow = row + dy
                        prevCol = col + dx
                        if isValid(prevRow, prevCol):
                            minPath = min(minPath, dp[prevRow][prevCol])
                    dp[row][col] += minPath
        return min(dp[rows - 1])
