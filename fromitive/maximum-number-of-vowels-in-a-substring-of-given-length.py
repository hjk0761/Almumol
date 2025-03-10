"""
title: Maximum Number of Vowels in a Substring of Given Length
link : https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/

description

정수 k와 문자열 s가 주어진다.
이때 k길이의 s의 substring의 모음의 최대값을 구해야 한다.

해결 방안

sliding-window를 활용하여 길이가 k 인 substring을 유지하며 최대값을 구할 수 있다.

삼항 연산자를 쓰면 성능이 안좋았다. Editorial을 보니 sliding-window에서 못 벗어나는 것 같은데 다른 방법을 한 번 생각해봐야겠다.
"""

class Solution:
    def maxVowels(self, s: str, k: int) -> int:
        answer = 0
        left = 0
        vowel = 0
        for right in range(len(s)):
            vowel += 1 if s[right] in {'a','e','i','o','u'} else 0
            while right - left + 1 > k:
                if s[left] in {'a','e','i','o','u'}:
                    vowel -= 1
                left += 1
            answer = max(answer, vowel)
        return answer 

    def maxVowelsEditorial(self, s: str, k: int) -> int:
        answer = 0 
        count = 0
        vowel = {'a','e','i','o','u'}
        for i in range(k):
            count += 1 if s[i] in vowel else 0
        answer = count
        for i in range(k, len(s)):
            count += 1 if s[i] in vowel else 0
            count -= 1 if s[i - k] in vowel else 0
            answer = max(answer, count)
        return answer

    def maxVowelsAdvenced(self, s: str, k: int) -> int:
        answer = 0 
        count = 0
        vowel = {'a','e','i','o','u'}
        for i in range(k):
            if s[i] in vowel:
                count += 1
        answer = count
        for i in range(k, len(s)):
            if s[i] in vowel:
                count += 1
            if s[i - k] in vowel:
                count -= 1
            answer = max(answer, count)
        return answer