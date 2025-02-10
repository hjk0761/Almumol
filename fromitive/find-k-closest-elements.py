""" 
title: Find K Closest Elements
link : https://leetcode.com/problems/find-k-closest-elements

description

'정렬된'정수 배열 arr이 주어진다. 이때 k와 x가 주어지는데, x에 가까운 1 ~ k 번째 숫자들을 반환해야 한다.
반환할때의 숫자는 오름차순으로 정렬되어 있어야 한다.

해결 방안
x와 가장 가까운 수를 구하기 위해선 x와 차이가 나지 않는 수다.
힙에 x와의 차이와 비교한 숫자를 넣는다. 
최대 힙을 이용해 길이 k를 유지하면서 x와 가장 차이 나는 값을 뺀다.

마지막엔 힙에 있는 숫자를 정렬하면 끝이다.
그러나 이 방법은 숫자가 정렬되어 있는걸 활용하지 못한 방법이다.
"""

import heapq
class Solution:
    def findClosestElements(self, arr: List[int], k: int, x: int) -> List[int]:
        heap = []
        for num in arr:
            distance = abs(x - num)
            heapq.heappush(heap, (-distance, -num))
            if len(heap) > k:
                heapq.heappop(heap)
        return sorted([-num for distance, num in heap])