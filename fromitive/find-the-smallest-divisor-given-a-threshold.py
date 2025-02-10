""" 
title: Find the Smallest Divisor Given a Threshold
link : https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold

description

양의 정수배열 nums가 있다. 정수 threshold가 주어질때 각 nums의 원소를 divisor로 나눈값의 합이 threshold보다 작거나 같은 최소 divisor 값을 구하자.

특히 divisor로 나눈 값이 소수점이 나올 경우 올림 처리한다.
"""

class Solution:
    def smallestDivisor(self, nums: List[int], threshold: int) -> int:
        left = 1
        right = max(nums)
        def check(divisor):
            totalSum = 0
            for num in nums:
                totalSum += ceil(num / divisor)
            return totalSum <= threshold
        while left < right:
            mid = (left + right) // 2
            if check(mid):
                right = mid
            else:
                left = mid + 1
        return left