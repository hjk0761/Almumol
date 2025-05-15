""" 
title: Binary Subarrays With Sum
link : https://leetcode.com/problems/binary-subarrays-with-sum/

description

0과 1로만 이루어진 배열 nums와 정수 goal이 주어질 때 nums의 subarray의 원소들의 합이 goal에 만족하는 subarray의 개수를 구한다.

해결 방안

prefix sum을 활용한다. {goal:currentSum}형태로 쌓다가 currenSum - goal이 hashMap에 있는지 확인한다. 
"""

class Solution:
    def numSubarraysWithSum(self, nums: List[int], goal: int) -> int:
        freq = {}
        currentSum = 0
        answer = 0
        for right in range(len(nums)):
            currentSum += nums[right]
            if currentSum == goal:
                answer += 1
            if currentSum - goal in freq:
                answer += freq[currentSum - goal]
            freq[currentSum] = freq.get(currentSum, 0) + 1
        return answer