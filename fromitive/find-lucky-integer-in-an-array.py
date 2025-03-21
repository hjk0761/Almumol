"""
title: Find Lucky Integer In an Array
link : https://leetcode.com/problems/count-elements-with-maximum-frequency

description
빈도수와 원소가 일치하는 원소의 최대 값을 구하자.

해결 방안
1. 처음엔 빈도수의 최대값을 바탕으로 원소가 존재하는지 확인했으나 이는 빈도수가 최대가 아니지만 원소와 빈도수가 같은 값을 가질 수 있는 경우를 고려하지 않아서 틀렸다.
2. 최대 빈도수와 원소가 일치해야 하므로 최대 빈도수의 원소만 찾으면 안된다. 
"""

from collections import Counter
class Solution:
    def findLucky(self, arr: List[int]) -> int:
        counter = Counter(arr)
        answer = -1
        for count in counter.values():
            if count in counter and counter[count] == count:
                answer = max(answer, count)
        return answer