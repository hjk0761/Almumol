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
        twiceNums = nums + nums
        stack = []
        hashMap = {}
        answer = []

        for i in range(len(twiceNums)):
            while stack and twiceNums[stack[-1]] < twiceNums[i]:
                before = stack.pop()
                hashMap[before] = twiceNums[i]
            stack.append(i)

        for i in range(len(nums)):
            answer.append(hashMap.get(i, -1))
        
        return answer