""" 
title: Determine if Two Strings Are Close
link : https://leetcode.com/problems/determine-if-two-strings-are-close

description

word1, word2가 유사한지 검사하는 코드를 작성해야 한다.

유사도 판별은 아래와 같은 연산으로 word1을 word2로 만들 수 있으면 유사도가 있음을 판단할 수 있다.

operation1 : 존재하는 문자를 아무 순서나 정렬할 수 있다.

operation2 : 문자를 해당 문자안에 존재하는 문자로 대치할 수 있다. 그러나 대치하는 문자의 숫자를 맞춰줘야 한다. 예를 들어 a가 3개 있으면 문자열 안에 있는 문자 아무 종류로 3개를 변환할 수 있다(e.g- aacabb -> bbcbaa)

해결 방안

위의 연산으로 볼 때 word1과 word2가 유사하다는 것을 확인하려면 word1과 word2가 같은 종류의 문자로 이루어져야하고 각 문자별 개수 분포가 동일해야 한다.

"""


from collections import Counter
class Solution:
    def closeStrings(self, word1: str, word2: str) -> bool:        
        counter1 = Counter(word1)
        counter2 = Counter(word2)
        
        return sorted(counter1.keys()) == sorted(counter2.keys()) and sorted(counter1.values()) == sorted(counter2.values())
        