"""
title: Minimum Path Sum
link : https://leetcode.com/problems/minimum-path-sum

description

m x n 행렬에 숫자가 주어졌을 때 top left부터 bottom-right까지의 경로로 가는 길의 모든 숫자를 더한 값의 최소 값을 구하자

"""

class Solution:
    def minPathSum(self, grid: List[List[int]]) -> int:
        dp = [[0] * len(grid[0]) for _ in range(len(grid))]
        dp[0][0] = grid[0][0]
        for row in range(len(grid)):
            for col in range(len(grid[row])):
                dp[row][col] = grid[row][col]
                if row > 0 and col > 0:
                    dp[row][col] += min(dp[row - 1][col], dp[row][col - 1])
                elif row > 0:
                    dp[row][col] += dp[row - 1][col]
                elif col > 0:
                    dp[row][col] += dp[row][col - 1]
        return dp[len(grid) - 1][len(grid[0]) -1]