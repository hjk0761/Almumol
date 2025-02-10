""" 
title: Longest Subsequence With Limitied sum
link : https://leetcode.com/problems/longest-subsequence-with-limited-sum

description

nums 배열과 queries 배열이 주어진다. 
이때 queries의 원소 마다 nums 배열로 만들 수 있는 subsequence 의 원소들의 합들보다 작은 subsequence의 개수를 각각 구해야한다.  
"""

class Solution:
    def answerQueries(self, nums: List[int], queries: List[int]) -> List[int]:
        nums.sort()
        prefix = []
        currentSum = 0
        for num in nums:
            currentSum += num
            prefix.append(currentSum)
        def rightMostSearch(arr, target):
            left = 0
            right = len(arr)
            while left < right:
                mid = (left + right) // 2
                if target < arr[mid]:
                    right = mid
                else:
                    left = mid + 1
            return left
        answer = []
        for query in queries:
            answer.append(rightMostSearch(prefix, query))
        
        return answer