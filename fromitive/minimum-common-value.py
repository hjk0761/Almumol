""" 
title: Minimum Common Value
link : https://leetcode.com/problems/minimum-common-value

description

num1 num2가 오름차순으로 정렬되어있을 때 공통으로 들어가 있는 원소의 최소값을 구한다.

해결 방안

1. set으로 만들어놓고 비교해가며 더하기 O(len(nums1) + len(nums2)) -> 
2. 정석으로 two pointer를 활용해 pointer를 옮겨가며 비교해도 오케이 O(len(num1) + len(num2))
3. Binary Search를 활용해서 좀 더 개선된 brute-force도 가능 O(len(num1) * log len(num2))
"""

class Solution:
    def getCommon(self, nums1: List[int], nums2: List[int]) -> int:
        pNum1 = 0
        pNum2 = 0
        while pNum1 < len(nums1) and pNum2 < len(nums2):
            if nums1[pNum1] == nums2[pNum2]:
                return nums1[pNum1]
            if nums1[pNum1] > nums2[pNum2]:
                pNum2 += 1
            elif nums1[pNum1] < nums2[pNum2]:
                pNum1 += 1
        return -1

    def getCommon(self, nums1: List[int], nums2: List[int]) -> int:
        set1 = set(nums1) # O(len(nums1))
        for num in nums:
            if num in set1: # O(1)
                return num
        return -1

    def getCommon(self, nums1: List[int], nums2: List[int]) -> int:
        def binarySearch(target, nums):
            left = 0
            right = len(nums) - 1
            while left <= right:
                mid = (left + right) // 2
                if nums[mid] == target:
                    return True
                if nums[mid] > target:
                    right = mid - 1
                elif nums[mid] < target:
                    left = mid + 1
            return False

        for num in nums1:
            if binarySearch(num, nums2):
                return num
        return -1