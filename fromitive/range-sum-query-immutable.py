"""
title: Range Sum Query - Immutable
link : https://leetcode.com/problems/range-sum-query-immutable 

description

NumArray 클래스는 배열의 range-sum을 구할 수 있는 객체이다.

해당 객체가 O(1)로 범위의 합을 구할 수 있도록 구현하자.
"""

class NumArray:
    def __init__(self, nums: List[int]):
        self.nums = nums
        self.prefix = []
        currentSum = 0
        for num in self.nums:
            currentSum += num
            self.prefix.append(currentSum)

    def sumRange(self, left: int, right: int) -> int:
        return self.prefix[right] - self.prefix[left] + self.nums[left]