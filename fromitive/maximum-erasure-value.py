"""
title: Maximum Erasure Value
link : https://leetcode.com/problems/maximum-erasure-value

description

양의 정수 배열 Nums가 주어질 때 모든 원소가 고유한 subArray의 합의 최대값을 구한다.

해결 방안

subarray이므로 순서가 보장되어 있다. set과 sliding-window를 이용하여 최대값을 구할 수 있다.
"""

from collections import Counter
class Solution:
    def maximumUniqueSubarray(self, nums: List[int]) -> int:
        counter = Counter()
        currentSum = 0
        left = 0
        answer = 0
        for right in range(len(nums)):
            currentSum += nums[right]
            counter[nums[right]] += 1
            while counter[nums[right]] > 1:
                counter[nums[left]] -= 1
                currentSum -= nums[left]
                left += 1
            answer = max(answer, currentSum)
        return answer