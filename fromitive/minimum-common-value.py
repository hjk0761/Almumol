""" 
title: Minimum Common Value
link : https://leetcode.com/problems/minimum-common-value

description

num1 num2가 오름차순으로 정렬되어있을 때 공통으로 들어가 있는 원소의 최소값을 구한다.

해결 방안

1. set으로 만들어놓고 min 해도 됨
2. 정석으로 two pointer를 활용해 pointer를 옮겨가며 비교해도 오케이
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
        common = set(nums1) & set(nums2)
        return min(common) if common else -1