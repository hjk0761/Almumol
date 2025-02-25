"""
title: Unique Paths
links: https://leetcode.com/problems/unique-paths

description

로봇이 있다. 이친구는 m * n 행렬에서 top-left(0,0)에 있는데 우측 또는 아래로만 이동할 수 있다
이때 bottom-right까지 갈 수 있는 경로의 수를 구하자.

해결 방안

현재 위치의 경로의 수를 저장하는 dp 배열을 정의하자.
"""

class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        dp = [[0] * m for _ in range(n)]
        dp[0][0] = 1

        for row in range(n):
            for col in range(m):
                if row > 0:
                    dp[row][col] += dp[row - 1][col]
                if col > 0:
                    dp[row][col] += dp[row][col -1]

        return dp[n - 1][m - 1]