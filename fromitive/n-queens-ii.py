""" 
title: N-Queens II
link : https://leetcode.com/problems/n-queens-ii

description
n * n 보드판에서 n개의 queen이 모두 놓을 수 있는 경우의 수의 합을 구한다.
"""
class Solution:
    def totalNQueens(self, n: int) -> int:
        def backtrack(row, cols, digonals, antiDigonals):
            if row == n + 1:
                return 1
            answer = 0
            for col in range(1, n + 1):
                
                nextDigonal = row + col
                nextAntiDigonal = row - col

                if (nextDigonal in digonals or
                    nextAntiDigonal in antiDigonals or
                    col in cols):
                    continue
                cols.add(col)
                digonals.add(nextDigonal)
                antiDigonals.add(nextAntiDigonal)
                
                answer += backtrack(row + 1, cols, digonals, antiDigonals)
                
                cols.remove(col)
                digonals.remove(nextDigonal)
                antiDigonals.remove(nextAntiDigonal)

            return answer
        return backtrack(1,set(), set(), set())