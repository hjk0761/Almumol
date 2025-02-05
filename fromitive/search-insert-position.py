""" 
title: Search Insert Position
link : https://leetcode.com/problems/search-insert-position

description

정렬된 배열 nums가 주어질때 target이 삽입할 수 있는 index를 구하자
"""

class Solution:
    def searchInsert(self, nums: List[int], target: int) -> int:
        left = 0
        right = len(nums) # 배열의 tail부분에 추가하는 경우까지 생각
        while left < right:
            mid = (left + right) // 2
            if target <= nums[mid]:
                right = mid
            else:
                left = mid + 1
        return left