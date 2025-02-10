""" 
title: Reduce Array Size to The Half
link : https://leetcode.com/problems/reduce-array-size-to-the-half

description

정수 배열 arr가 있다. arr에는 중복을 허용한 정수 원소들이 있으며 한 원소를 제거하면 중복된 다른 원소들도 제거 가능하다.
arr의 길이가 절반 이하가 되는 원소의 종류의 최소 개수를 구한다. 
"""
from collections import Counter
class Solution:
    def minSetSize(self, arr: List[int]) -> int:
        counter = Counter(arr)
        target = len(arr) / 2
        counts = sorted(counter.values(),reverse = True)
        i = 0
        while i < len(counts) and target > 0:
            target -= counts[i]
            i += 1
        return i
