""" 
title: K Closest Points to Origin
link : https://leetcode.com/problems/k-closest-points-to-origin/

description

2차원 좌표를 원소로 갖는 points 배열이 주어진다. 이때 (0,0)에서 1 ~ k 번째까지 거리가 가까운 point를 구한다.

해결 방안

최대 힙을 써서 point와 0,0 까지의 거리를 구한 후 길이 k 를 유지한다. 길이가 k 보다 커지면 Pop을하여 가장 멀리 있는 point를 없앤다.
"""

import heapq
class Solution:
    def kClosest(self, points: List[List[int]], k: int) -> List[List[int]]:
        heap = []
        for point in points:
            distance = point[0] ** 2 + point[1] ** 2
            heapq.heappush(heap, (-distance, point))
            if len(heap) > k:
                heapq.heappop(heap)
        
        return [point for distance, point in heap]
