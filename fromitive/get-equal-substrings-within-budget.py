""" 
title: Get Equal Substrings Within Budget
link : https://leetcode.com/problems/get-equal-substrings-within-budget

description

길이가 같은 문자열 s와 t가 주어진다. 이때 s의 i번째 문자를 i번째 t문자로 변환하고자 할때 abs(s[i] - t[i]) 비용이 든다.

maxCost값이 주어질 때 s가 t로 변환하기 위한 subString의 최대 길이를 구하자.


해결 방안

sliding window 식을 세운다. 한 문자의 cost가 maxCost값보다 높아질 수 있으니 이점을 주의하자.

left 포인터는 right 포인터보다 크지 않게 설정한다.
"""

class Solution:
    def equalSubstring(self, s: str, t: str, maxCost: int) -> int:
        cost = 0
        left = 0 
        answer = 0 
        for right in range(len(s)):
            cost += abs(ord(s[right]) - ord(t[right]))
            while left <= right and cost > maxCost:
                cost -= abs(ord(s[left]) - ord(t[left]))
                left +=1
            answer = max(answer, right - left + 1)
        return answer