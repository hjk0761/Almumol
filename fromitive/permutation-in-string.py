"""
title: Permutation in String
link : https://leetcode.com/problems/permutation-in-string

description

두 문자열 s1, s2가 주어진다. s1이 s2의 조합일 때 True 그렇지 않으면 False를 반환한다.

해결 방안
s1의 문자열을 샌다, s2를 순회하면서 sliding-window로 s1을 만족하는 원소를 계속 더해가면서 개수 일치 여부를 판단한다.
"""


from collections import Counter
class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        counter = Counter(s1)
        left = 0
        current = Counter()
        for right in range(len(s2)):
            current[s2[right]] += 1
            while left <= right and (s2[right] not in counter or current[s2[right]] > counter[s2[right]]):
                current[s2[left]] -= 1
                left += 1
            if current == counter:
                return True
        return False