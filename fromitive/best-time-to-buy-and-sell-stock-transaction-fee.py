""" 
title: Best Time to Buy and Sell Stock IV
link : https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv

description

prices는 시간대별 주식의 가격이다.
트렌젝션(구매 후 판매) 한 건당 fee만큼의 수수료가 붙을 때 최대 이익을 구하는 프로그램을 구하자.

해결 방안

best-time-to-buy-and-sell-stock-iv의 쉬운 버전의 문제이다.

각 price마다 할 수 있는 행동은 buy or sell이다. 이에 대한 점화식을 작성하면 된다.
"""

class Solution:
    def maxProfit(self, prices: List[int], fee: int) -> int:
        n = len(prices)
        dp = [[0] * (n + 1) for _ in range(2)]

        for i in range(n - 1, -1, -1):
            for holding in range(2):
                answer = dp[holding][i + 1] # skip
                if holding:
                    answer = max(answer, prices[i] + dp[0][i + 1] - fee)
                else:
                    answer = max(answer, -prices[i] + dp[1][i + 1])
                dp[holding][i] = answer

        return dp[0][0]
