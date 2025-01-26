"""
title : Sliding Window Maximum
link  : https://leetcode.com/problems/sliding-window-maximum

description

정수 배열 nums와 sliding-window size인 k가 주어졌을 때, 각 sliding-window의 최대값들을 반환한다.


해결 방안

monotonic-decrease를 구현하면 내림차순으로 쌓이게 된다. 
queue안에는 무조건 nums의 원소가 들어가게 되고, queue[0]에는 항상 최대값이 보장된다.
원소의 특정 인덱스 i를 기준으로 queue[0] + k == i를 만족하면 sliding-window를 넘어선 것이므로 popleft()를 하여 값에서 제외시킨다.
제외를 시키면 두 번째로 큰 원소가 sliding-window에서 제일 큰 값이 되며 무조건 queue[0]은 sliding-window에서 가장 큰 값이 된다.
"""

from collections import deque

class Solution:
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        queue = deque()
        answer = []
        for i in range(len(nums)):
            while queue and nums[i] > nums[queue[-1]]:
                queue.pop()
            queue.append(i)
            
            if queue[0] + k == i:
                queue.popleft()
            
            if i >= k - 1:
                answer.append(nums[queue[0]])
    
        return answer