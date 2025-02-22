""" 
title: Maximum Value of Coins From Piles
link : https://leetcode.com/problems/maximum-value-of-k-coins-from-piles/description/

description

동전 주머니 배열인 piles가 주어진다. piles(차곡차곡쌓음)는 위에 있는 동전만 꺼낼 수 있게 구성되어 있다.

동전을 k 회 선택할 수 있을때 제일 많이 꺼낼 수 있는 돈을 구하자

해결 방안

첫 번째 pile 부터 순차적으로 순횐한다. 첫 번째 pile을 선택할 경우, 다음 pile을 선택하는 경우를 나눠 brute force하자.
"""

class Solution:
    def maxValueOfCoins(self, piles: List[List[int]], k: int) -> int:
        @cache
        def dp(i, remain):
            if i == len(piles) or remain == 0:
                return 0
            answer = dp(i + 1, remain)
            coins = 0
            for j in range(min(len(piles[i]) , remain)):
                coins += piles[i][j]
                answer = max(answer, coins + dp(i + 1, remain - j - 1))
            return answer

        return dp(0, k)
