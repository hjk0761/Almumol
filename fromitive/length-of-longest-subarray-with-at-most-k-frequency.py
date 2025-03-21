""" 
title: Length of Longest Subarray With at Most K Frequency
link : https://leetcode.com/problems/length-of-longest-subarray-with-at-most-k-frequency

description

정수 배열 nums와 양의 정수 k가 주어질 때 nums의 각 빈도 수가 k 를 넘기지 않는 subArray의 최대 길이를 구해야 한다.

해결 방안

sliding-window로 상시 빈도수를 체크한다. O(N)의 시간 복잡도를 만족함
"""

class Solution:
    def maxSubarrayLength(self, nums: List[int], k: int) -> int:
        #solution 1: sliding window
        left = 0 
        hashMap = {}
        answer = 0
        for right in range(len(nums)):
            hashMap[nums[right]] = hashMap.get(nums[right], 0) + 1
            while hashMap[nums[right]] > k:
                hashMap[nums[left]] -= 1
                left += 1
            answer = max(answer, right - left + 1)
        return answer