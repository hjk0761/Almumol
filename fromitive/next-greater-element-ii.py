""" 
title : Next Greater Element II
link  : https://leetcode.com/problems/next-greater-element-ii

description

순환 배열 nums가 주어진다. 

이때 각 nums의 원소 별로 다음 큰 수를 구해야 한다.

해결 방안

circular를 최소 2번 돌아야 한다.

next greater는 단조 스택을 통해 구현해보자
"""
class Solution:
    def nextGreaterElements(self, nums: List[int]) -> List[int]:
        stack = []
        answer = [-1] * len(nums)
        for i in range(len(nums) * 2):
            num = nums[i % len(nums)]
            while stack and stack[-1][1] < num:
                j,_ = stack.pop()
                answer[j] = num
            stack.append([i % len(nums), num])
        return answer
