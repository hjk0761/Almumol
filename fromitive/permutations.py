""" 
title: Permutations
link : https://leetcode.com/problems/permutations

description

배열 nums가 주어지면 순열 목록을 반환하는 코드를 작성하시오
"""
class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        answer = []
        def backtrack(nums, choice):
            if len(nums) == 0:
                answer.append(choice[:])
            
            for i in range(len(nums)):
                pickNums = nums[:i] + nums[i + 1 :]
                choice.append(nums[i])
                backtrack(pickNums, choice)
                choice.pop()
        backtrack(nums, [])
        return answer