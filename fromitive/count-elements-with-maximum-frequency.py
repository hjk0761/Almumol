"""
title: Count Elements With Maximum Frequency
link : https://leetcode.com/problems/count-elements-with-maximum-frequency

description

nums의 최대 원소 빈도수인 원소들의 빈도 수 값의 합을 구하자.
"""

from collections import Counter
class Solution:
    def maxFrequencyElements(self, nums: List[int]) -> int:
        counter = Counter(nums)
        countCounter = Counter(counter.values())
        maxFreq = max(counter.values())
        return maxFreq * countCounter[maxFreq]