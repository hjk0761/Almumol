"""
title : Valid Parenthesis
link  : https://leetcode.com/problems/valid-parenthesis

description
괄호들(`{}()[]`)로 이루어진 문자열 s가 주어질 때 괄호가 제대로 닫혀졌는지 확인하는 코드를 작성해야 한다.
"""
class Solution:
    def isValid(self, s: str) -> bool:
        matcher = {"(": ")", "{": "}", "[":"]"}
        stack = []
        for c in s:
            if c in matcher:
                stack.append(c)
            else:
                if len(stack) == 0:
                    return False
                left = stack.pop()
                if matcher[left] != c:
                    return False
        return len(stack) == 0