""" 
title: Best Time to Buy and Sell Stock IV
link : https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv

description

prices는 시간대별 주식의 가격이다.
k는 시도할 수 있는 트렌젝션 수이다.
트렌젝션은 주식을 구매하고 판매할 때 1개 감소한다.
k가 0일때 더이상 거래할 수 없을 때 가장 큰 이익을 반환하는 코드를 작성한다.

해결 방안

dynamic programming의 핵심은 decision maker를 정의하는 것이다.

stock은 내일 사고 오늘 팔 수 없다. day는 + 1 씩만 가능하다. 또한 len(prices) 까지 도달하게 되면 더이상 거래할 수 없다.

사는 것과 파는건 한 번 밖에 못한다. 또한 파는건 보유할 때만 가능하다. holding 변수를 추가해서 이를 관리해줄 수 있다.

살때 -> holding = True
팔때 -> holding = False, *이익 실현*

이익 실현은 어떻게 정의하면 좋을까? 살때는 prices[days]의 가격을 음수로 맞추고 팔때는 prices[days]를 양수로 가져가면 되지 않을까?

그리고 홀딩하지 않을때는 그냥 다음날 부터 위와 똑같은 결정을 반복하면 된다 언제까지? 가능한 트렌젝션이 모두 소진되거나 day가 price 가격만큼 꽉찰때까지
"""

class Solution:
    def maxProfit(self, k: int, prices: List[int]) -> int:
        @cache
        def dfs(day, holding, remain):
            if day == len(prices) or remain == 0:
                return 0
            ans = dfs(day + 1, holding, remain)
            if holding:
                ans = max(ans, prices[day] + dfs(day + 1, False, remain - 1))
            else:
                ans = max(ans, -prices[day] + dfs(day + 1, True, remain))
            
            return ans
        return dfs(0, False, k)
                