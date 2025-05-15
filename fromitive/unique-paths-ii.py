""" 
title: Unique Paths II
link : https://leetcode.com/problems/unique-paths-ii/

description

로봇이 있다. 이친구는 m * n 행렬에서 top-left(0,0)에 있는데 우측 또는 아래로만 이동할 수 있다.
이때 조건이 하나 추가되는데 m * n 인 2차원 배열 obstacleGrid이 하나 주어지고 obstacleGrid[i][j] == 1 이면 로봇이 지나갈 수 없다.
이때 bottom-right까지 갈 수 있는 경로의 수를 구하자. 

해결방안

dp[row][col]은 row, col 위치에서의 지나갈 수 있는 경로의 수이다.
obstcleGrid[row][col] == 1 일때 절대 지나갈 수 없으므로 continue로 생략하자.

"""

class Solution:
    def uniquePathsWithObstacles(self, obstacleGrid: List[List[int]]) -> int:
        rows = len(obstacleGrid)
        cols = len(obstacleGrid[0])
        
        dp = [[0] * cols for _ in range(rows)]
        dp[0][0] = 1
        
        if obstacleGrid[0][0] == 1:
            return 0
        
        for row in range(rows):
            for col in range(cols):
                if obstacleGrid[row][col] == 1:
                    continue
                if row > 0:
                    dp[row][col] += dp[row - 1][col]
                if col > 0:
                    dp[row][col] += dp[row][col - 1]

        return dp[rows - 1][cols - 1]
