""" 
title: Unique Number of occurrences
link : https://leetcode.com/problems/unique-number-of-occurrences/

description

원소의 개수와 빈도수 값들이 중복이 없음을 검증해야 한다.
"""

from collections import Counter
class Solution:
    def uniqueOccurrences(self, arr: List[int]) -> bool:
        counter = Counter(arr)
        counts = counter.values()
        return len(counter.keys()) == len(set(counter.keys())) and len(counts) == len(set(counts)) 