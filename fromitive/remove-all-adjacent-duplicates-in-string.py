"""
title : Remove All Adjacent Duplicates in String
link  : https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/

description

인접한 두 문자열이 같을 경우 제거하여 최종 결과를 반환해야 한다. 예를 들어 "aabbccde"가 주어졌을때 "de"가 최종적으로 반환해야할 값이다.

"""

class Solution:
    def removeDuplicates(self, s: str) -> str:
        stack = []
        for c in s:
            if len(stack) == 0 or stack[-1] != c:
                stack.append(c)
            elif stack[-1] == c:
                stack.pop()
        return "".join(stack)