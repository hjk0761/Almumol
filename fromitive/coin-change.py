""" 
title: Coin Change
link : https://leetcode.com/problems/coin-change

description

동전 금액이 담겨있는 있는 coins 배열이 있다. 목표 금액 amount가 주어질 때 coins에 있는 동전을 중복으로 쓰면서 바꿀 수 있는 경우의 수를 구하자.

해결 방안

해당 문제는 dp[amount] = dp[amount - coin] + 1 를 만족한다.

coins의 배열을 순회하면서 amount - coin >= 0을 만족하는 coin 값들의 바꿀 수 있는 경우의 수들의 최소값을 점진적으로 구하자.
"""


class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        dp = [float('inf')] * (amount + 1)
        dp[0] = 0
        for i in range(amount + 1):
            for j in coins:
                if i - j >= 0:
                    dp[i] = min(dp[i], dp[i - j] + 1)
        return dp[amount] if dp[amount] != float('inf') else -1
