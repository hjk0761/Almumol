""" 
title: Min Cost Climbing Stairs
link : https://leetcode.com/problems/min-cost-climbing-stairs

description

n 칸인 계단이 존재한다. 각 계단의 층은 다음 칸에 오르기 위한 cost가 기입되어 있다. 

예를 들어 costs[i] 가 50일때 i번째 계단을 넘어서기 위해서 costs[i] 만큼의 에너지가 필요하다는 뜻이다.

계단을 넘을 땐 한 칸(i + 1) 혹은 두 칸 (i + 2)를 넘을 수 있는데 계단을 끝까지 오르기 위한 최소 에너지를 구하자.

해결 방안

top-down dp로 해결할 수 있다. 
이미 goal에 도착했다고 가정할 때 1칸 아래인 계단의 cost 혹은 2칸 아래의 계단의 cost 중 적은 값을 선택하는 형태로 base case까지 내려가며 계산한다.

base Case인 경우는 len(costs)가 1이하일 때이다. 계단은 한 번에 2칸씩 오를 수 있기 때문에 base case의 cost는 0이 들기 때문이다.
"""

class Solution:
    def minCostClimbingStairs(self, cost: List[int]) -> int:
        dp = {}
        def dfs(i):
            if i <= 1:
                return 0
            if i in dp:
                return dp[i]
            dp[i] = min(cost[i - 1] + dfs(i - 1), cost[i - 2] + dfs(i - 2))
            return dp[i]
        return dfs(len(cost))
            