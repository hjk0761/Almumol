"""
title: Generate Parenthesis
link : https://leetcode.com/problems/generate-parentheses

description 

n 개만큼의 괄호("()")를 조합하는 모든 경우의 수를 구하자
"""

class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        def backtrack(path, openP, closeP):
            if len(path) == n * 2:
                answer.append("".join(path))
                return
            if openP < n:
                path.append("(")
                backtrack(path, openP + 1, closeP)
                path.pop()
            if closeP < openP:
                path.append(")")
                backtrack(path, openP, closeP + 1)
                path.pop()
        answer = []
        backtrack([],0,0)
        return answer