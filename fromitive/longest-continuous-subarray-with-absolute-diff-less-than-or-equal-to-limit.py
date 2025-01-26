"""
title : Longest Continuous Subarray With Absolute Diff Less Than or Equal to Limit 
link  : https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit

description

정수 배열 nums가 주어질 때 각 원소들의 절대값 차이가 limit보다 작거나 같은 continuous subarray(원소가 순서를 유지하는 subArray)를 구해라  

해결 방안

continuous subarray를 찾는 것은 sliding-window가 적합하다. 

subarray의 각 원소들의 차이가 limit보다 작기 위해선 subarray의 최대 최소값의 차이가 limit 보다 작거나 같으면 된다.

최대 최소 값을 유지하면서, continuous subarray를 유지하는 코드를 작성하면 됨

"""
from collections import deque

class Solution:
    def longestSubarray(self, nums: List[int], limit: int) -> int:
        increasing = deque()
        decreasing = deque()
        left = 0
        answer = 0 
        for right in range(len(nums)):
            while increasing and increasing[-1] > nums[right]:
                increasing.pop()
            increasing.append(nums[right])

            while decreasing and decreasing[-1] < nums[right]:
                decreasing.pop()
            decreasing.append(nums[right])
            
            while decreasing[0] - increasing[0] > limit:
                if decreasing[0] == nums[left]:
                    decreasing.popleft()
                if increasing[0] == nums[left]:
                    increasing.popleft()
                left += 1
            answer = max(answer, right - left + 1)
        return answer