""" 
title: Move Zeroes
link : https://leetcode.com/problems/move-zeroes

description

숫자 배열 nums안에 있는 0을 전부 뒤로 보내는 코드를 작성해야 한다.

해결 방안

nums 안에 있는 모든 원소를 탐색하는 index와 숫자가 0이 아닐때만 증가하는 포인터를 이용한다.
그렇게 하면 O(nums) 시간복잡도를 만족하도록 작성할 수 있다.
"""

class Solution:
    def moveZeroes(self, nums: List[int]) -> None:
        left = 0
        for right in range(len(nums)):
            if nums[right] != 0:
                nums[left] = nums[right]
                left += 1
        for i in range(left, len(nums)):
            nums[i] = 0