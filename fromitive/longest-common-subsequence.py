""" 
title: Longest Common Subsequences
link : https://leetcode.com/problems/longest-common-subsequence

description

문자 text1, text2가 주어질 때 Longest Common Subsequence를 찾는다.

Common Subsequence란 text1과 text2의 순서를 유지한 채 두 문자열안에 있는 문자들을 제거하여 공통 부분을 추출한 문자열이다.

해결 방안

작은 문제로 나뉠 수 있는지 확인한다.

문자열을 비교하는 방법은 text1의 처음 문자부터 시작해서 text2 문자들을 비교한다. 나올 수 있는 경우의 수는 두가지다

1. text1과 text2 문자가 일치하는 경우
- 최초로 만난 두 문자가 일치하면 text1의 다음 문자와 text2의 다음 문자를 비교한다.
2. text1과 text2 문자가 일치하지 않은 경우
- text1의 인덱스를 올리거나 text2의 인덱스를 올려서 둘 중의 최대값을 선택한다.

재계산을 하기 위해 memoization을 위한 딕셔너리 변수 하나 추가한다.
"""

class Solution:
    def longestCommonSubsequence(self, text1: str, text2: str) -> int:
        dp = {}
        def dfs(i, j):
            if i == len(text1) or j == len(text2):
                return 0
            if (i, j) in dp:
                return dp[(i,j)]

            if text1[i] == text2[j]:
                dp[(i,j)] = 1 + dfs(i + 1, j + 1)
            else:
                dp[(i,j)] = max(dfs(i + 1, j), dfs(i, j + 1))

            return dp[(i,j)]
        return dfs(0 ,0) 

