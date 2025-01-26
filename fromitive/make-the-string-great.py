"""
title : Make The String Great
link  : https://leetcode.com/problems/make-the-string-great

description

문자열 s가 주어졌을 때 인접한 두 문자가 같지만 대소문자가 다를 경우 이를 제거한다.
이렇게 최종적으로 제거되어 남은 문자를 구해야 한다.
"""

class Solution:
    def makeGood(self, s: str) -> str:
        stack = []
        for c in s:
            if len(stack) != 0 and stack[-1].lower() == c.lower():
                if stack[-1].isupper() != c.isupper():
                    stack.pop()
                    continue
            stack.append(c)
        return "".join(stack)