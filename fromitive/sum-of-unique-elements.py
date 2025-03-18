"""
title: Sum of Unique Elements
link : https://leetcode.com/problems/sum-of-unique-elements

description

nums안에 있는 중복이 없는 고유한 원소들의 합을 구하자.

해결 방안
Counter를 사용하여 원소별 개수를 구한 후 1개인 원소들의 합을 구한다.
"""

from collections import Counter
class Solution:
    def sumOfUnique(self, nums: List[int]) -> int:
        counter = Counter(nums)
        answer = 0
        for key in counter:
            if counter[key] == 1:
                answer += key
        return answer