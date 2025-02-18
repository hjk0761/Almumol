""" 
title: Climbing Stairs
link : https://leetcode.com/problems/climbing-stairs

description

n 칸의 계단이 있다. 한번 오를때 한 칸 혹은 두 칸 오를 수 있을 때 n 칸의 게단을 오를 수 있는 경우의 수를 출력하자.

해결 방안

n 칸 계단을 오를 수 있는 수는 n - 1 또는 n - 2 계단을 오를 경우를 합친 수이다. 왜냐하면 게단은 한 칸 혹은 두 칸만 오를 수 있기 때문이다.
"""

class Solution:
    def climbStairs(self, n: int) -> int:
        if n == 1:
            return 1
        if n == 2:
            return 2
        dp = dict()
        dp[1] = 1
        dp[2] = 2
        
        for i in range(3, n + 1):
            dp[i] = dp[i - 1] + dp[i - 2]
        return dp[n]
