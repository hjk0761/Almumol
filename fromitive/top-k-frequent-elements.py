"""  
title : Top K Frequent Element
link  : https://leetcode.com/problems/top-k-frequent-elements

description

숫자 배열 nums가 있다. 원소들은 중복을 허용한다. 이때 K번째 까지의 빈도수가 높은 숫자를 추출해야 한다. 단, 추출할 경우 각 원소들은 중복을 허용하지 않는다. 
"""

from collections import Counter
import heapq
class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        counter = Counter(nums)
        heap = []
        for num, count in counter.items():
            heapq.heappush(heap, (count, num))
            if len(heap) > k:
                heapq.heappop(heap)
        return [ num for count, num in heap]