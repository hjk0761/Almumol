""" 
title: Custom Sort String
link : https://leetcode.com/problems/custom-sort-string

description
문자들이 고유한 order가 있다.
문자열 s를 order에 적힌 문자 순서에 맞게 정렬한 결과를 줘야한다.
order에 없는 문자들은은는 어떤 순서에 와도 상관 없다.

"""


from collections import Counter
class Solution:
    def customSortString(self, order: str, s: str) -> str:
        # 문자들이 고유한 order가 있다.
        # 문자열 s를 order순서에 맞게 정렬한 결과를 줘야한다.
        # order에 없는 문자는 어떤 순서에 와도 상관 없다.
        # s에 있는 문자들에 중복 문자열이 있으면 어떻게? 정렬할까?
        # order = bcda s aanbbccdd bbccddaa
        # s = Counter
        # 해결방안
        orderDict = dict() # index : order character
        chCounter = Counter(s)
        unOrdered = set()
        answer = []
        
        # mapper 등록
        for idx in range(len(order)):
            orderDict[idx] = order[idx]
        
        # s 재배치
        for idx in range(len(order)):
            answer.append(orderDict[idx] * chCounter[orderDict[idx]])
            del chCounter[orderDict[idx]]
        
        # 나머지 문자 배치
        for unorderedCh in chCounter:
            answer.append(unorderedCh * chCounter[unorderedCh])
        
        return ''.join(answer)
