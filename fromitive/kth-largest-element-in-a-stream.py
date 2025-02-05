"""
title: Kth Largest Element in Stream
link : https://leetcode.com/problems/kth-largest-element-in-a-stream

description

KthLargest를 구현해야 한다. 생성자 인자는 정수 k와 nums로 이루어져 있다.
add(val)을 했을 때 nums에서 k번째로 큰 정수를 반환해야 한다.
"""

import heapq
class KthLargest:

    def __init__(self, k: int, nums: List[int]):
        self.k = k
        self.heap = []
        for num in nums:
            heapq.heappush(self.heap, num)
            if len(self.heap) > self.k:
                heapq.heappop(self.heap)

    def add(self, val: int) -> int:
        heapq.heappush(self.heap, val)
        if len(self.heap) > self.k:
            heapq.heappop(self.heap)
        return self.heap[0]
