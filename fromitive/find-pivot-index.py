"""
title: Find Pivot Index
link : https://leetcode.com/problems/find-pivot-index

description

정수 배열 nums가 주어질 때 nums[i]를 제외하고 i 번째 기준으로 왼쪽과 오른쪽의 합이 같은 경우 i를 pivot index라고 한다. 이를 구하자. pivot index가 없을 경우 -1을 반환한다.
단 i 가 0일 경우 왼쪽의 합을 0으로 간주하자.


해결 방안

전체합을 구한 후 절반만 탐색하면 O(2n)으로 마무리 가능하다.
오른쪽을 탐색하나 왼쪽을 탐색하나. 똑같으니 왼쪽부터 탐색해도 상관 없다. 이부분이 특히하다.
"""

class Solution:
    def pivotIndex(self, nums: List[int]) -> int:
        totalSum = sum(nums)
        leftSum = 0
        for i in range(len(nums)):
            if leftSum == totalSum - leftSum - nums[i]: # nums[i]를 제외한 leftSum이 rightSum과 일치하는지 판단.
                return i
            leftSum += nums[i]
        return -1