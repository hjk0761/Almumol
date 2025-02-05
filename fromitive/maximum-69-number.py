""" 
title: Maximum 69 Number
link : https://leetcode.com/problems/maximum-69-number

description

양의 정수 Num이 주어진다. num은 6또는 9로 이루어져있는데 딱 한번 6과 9를 바꿀 수 있다.
이때 num을 이용해서 최대한 큰 수를 만들자.

해결 방안

높은 자릿수에 있는 6를 9로만들면 최대 값을 구할 수 있다.
"""

class Solution:
    def maximum69Number (self, num: int) -> int:
        numString = str(num)
        for i in range(len(numString)):
            if numString[i] == '6':
                return int(numString[:i] + '9' + numString[i + 1:])
        return num
