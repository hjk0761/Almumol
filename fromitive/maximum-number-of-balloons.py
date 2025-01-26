"""  
title : Maximum Number of Ballons
link  : https://leetcode.com/problems/maximum-number-of-balloons/

description
소문자로 이루어진 문자열 s가 주어질 때 'ballons'를 만들 수 있는 최대 개수를 구하자.
"""
class Solution:
    def maxNumberOfBalloons(self, text: str) -> int:
        counter = {}
        baseCounter = {}

        for c in 'balloon':
            baseCounter[c] = baseCounter.get(c, 0) + 1
            
        for c in text:
            counter[c] = counter.get(c, 0) + 1
        answer = 0

        for c in baseCounter:
            if not c in counter:
                return 0    
            if c in counter and counter[c] < baseCounter[c]:
                return 0
            if answer == 0:
                answer = int(counter[c] / baseCounter[c])
            answer = min(answer, int(counter[c] / baseCounter[c]))

        return answer