""" 
title: Reverse Prefix of Word
link : https://leetcode.com/problems/reverse-prefix-of-word

description

문자열 word와 문자 ch가 주어질 때 word안에 ch가 존재할 경우 word의 첫글자부터 ch까지의 문자를 뒤집은 결과를 반환하자.
"""

class Solution:
    def reversePrefix(self, word: str, ch: str) -> str:
        left = 0
        right = 0
        wordArr = [ ch for ch in word ]
        while right < len(word):
            if wordArr[right] == ch:
                    break
            right += 1
    
        if right == len(word):
            return word

        while left < right:
            wordArr[left], wordArr[right] = wordArr[right], wordArr[left]
            left += 1
            right -= 1
        return "".join(wordArr)