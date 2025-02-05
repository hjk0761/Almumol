""" 
title: Yeah But How
link : https://softeer.ai/practice/9498

description

( 와 )만 이루어진 문자열 S가 주어질 때 1과 + 를 이용하여 올바른 수식을 만들어서 출력해야 한다.

"""

import sys

def solve(S):
    result = []
    before = ''
    for c in S:
        if before == '(' and c == '(':
            pass
        if before == '(' and c == ')':
            result.append('1')
        if before == ')' and c == '(':
            result.append('+')
        if before == ')' and c == ')':
            pass
        before = c  
        result.append(c)
    return "".join(result)

S = input()
print(solve(S))