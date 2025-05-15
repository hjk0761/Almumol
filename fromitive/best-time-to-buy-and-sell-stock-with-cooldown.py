"""
title: Best Time to Buy and Sell Stock with Cooldown
link : https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown

description

prices는 시간대별 주식의 가격이다. 
가장 많이 벌 수 있는 금액을 구해야 한다.
단, 주식을 판매하면 다음날은 거래가 불가능하다.
"""

class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        n = len(prices)
        dp = [[0] * (n + 1) for _ in range(3)] # dp[prices][actions]
        
        for i in range(n - 1, -1, -1):
            for holding in range(3):
                answer = dp[holding][i + 1]
                if holding == 1: # sell
                    answer = max(answer, prices[i] + dp[2][i + 1])
                if holding == 0: # buy
                    answer = max(answer, -prices[i] + dp[1][i + 1])
                if holding == 2: # cooldown
                    answer = max(answer, dp[0][i + 1])
                dp[holding][i] = answer
    
        return dp[0][0]