"""
title: Combinations 
link : https://leetcode.com/problems/combinations

description

n 과 k 가 주어질 때 n 이하의 수를 조합하여 길이가 k인 모든 조합을 반환한다. 조합되는 숫자는 중복을 허용하지 않는다.

"""

class Solution:
    def combine(self, n: int, k: int) -> List[List[int]]:
        answer = []
        def backtracking(current, start):
            if len(current) == k:
                answer.append(current[:])
            for num in range(start, n + 1):
                current.append(num)
                backtracking(current, num + 1)
                current.pop()
        backtracking([], 1)
        return answer