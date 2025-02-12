""" 
title: Letter Combinations of a Phone Number
link : https://leetcode.com/problems/letter-combinations-of-a-phone-number

description

휴대폰 번호판이 있다. 2 ~ 9 에는 문자가 있는데 숫자 문자열 digits로 만들 수 있는 문자의 조합을 전부 반환하자

해결 방안

tree가 있다고 생각하고, 깊이가 문자의 길이가 되면 지금까지 조합한 문자를 반환한다.
"""

class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        def backtrack(current, letter):
            if current == len(digits): # i == 2
                answer.append("".join(letter))
                return
            
            for c in graph[digits[current]]:
                letter.append(c)
                backtrack(current + 1, letter)
                letter.pop()
        if digits == "":
            return []
    
        graph = {
            "2" : "abc",
            "3" : "def",
            "4" : "ghi",
            "5" : "jkl",
            "6" : "mno",
            "7" : "pqrs",
            "8" : "tuv",
            "9" : "wxyz"
        }
        answer = []
        backtrack(0,[])
        return answer
