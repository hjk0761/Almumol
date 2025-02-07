""" 
title: Subsets
link : https://leetcode.com/problems/subsets

description

배열 Nums의 중복 원소 없는 모든 부분집합을 구하자

해결 방안

backtracking을 사용하여 한 번 선택한 원소는 다시 선택하지 못하도록 한다. 
"""

class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        answer = []

        def backtrack(current, start):
            if start > len(nums):
                return
            answer.append(current[:])

            for i in range(start,len(nums)):
                current.append(nums[i])
                backtrack(current, i + 1)
                current.pop()
        backtrack([], 0)
        return answer