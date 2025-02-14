"""
title: House Robber
link : https://leetcode.com/problems/house-robber/

description

당신은 도둑이다. nums 배열이 주어질 때 nums[i]는 각 집이 가지고 있는 돈이다. 

집을 털 때 한 집을 털고 주변에 있는 집을 털면 경찰에게 걸리게 된다. 따라서 당신은 경찰의 눈을 피하고 최대한 돈을 쓸어담아야 한다.

nums[i] 정보를 쥐어지고 최대로 벌 수 있는 돈을 구하는 코드를 작성한다.


해결 방안

n개의 집이 있고 각 집을 순서대로 방문한다고 가정해보자.

현재 터는 집을 i 번째라고 가정한다면, 현재까지 최대로 벌 수 있는 돈은 지금 있는 집을 털었을때와 털지 않았을 때로 구분할 수 있다.

지금 있는 집을 털면 이전 집은 털 수 없으므로 포기하거나 집을 털거나 두 선택지를 선택해야 하는데, 선택에 대한 기준은 최대값을 결정하면 된다. 

즉, dp[i] = max(nums[i] + dp[i - 2], dp[i - 1)이라는 점화식이 완성된다.
"""

class Solution:
    def rob(self, nums: List[int]) -> int:
        if len(nums) == 1:
            return nums[0]

        if len(nums) == 2:
            return max(nums[0], nums[1])
        
        dp = [0] * len(nums)
        dp[0] = nums[0]
        dp[1] = max(nums[0], nums[1])

        for i in range(2, len(nums)):
            dp[i] = max(dp[i - 1], dp[i - 2] + nums[i])
        return dp[-1]