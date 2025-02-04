""" 
title: Kth Largest Element in an Array
link : https://leetcode.com/problems/kth-largest-element-in-an-array

description

정수 배열 array가 주어질 때 k번째로 큰 숫자를 구해야 한다. 이때 정렬 쓰지 않고 구할 수 있는 방법을 사용해보자

해결 방안

nums를 힙으로 변경할 때 O(log n)의 시간복잡도가 소요되고, k 번까지 pop하는 과정으로 k번째 수를 구할수 있다. 최종적으로 O(logn + logk)의 시간복잡도가 든다.
"""

import heapq
class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        heap = [-num for num in nums]
        heapq.heapify(heap)
        for _ in range(k - 1):
            heapq.heappop(heap)
        return -heapq.heappop(heap)
