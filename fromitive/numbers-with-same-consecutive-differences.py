""" 
title: Numbers With Same Consecutive Differences
link : https://leetcode.com/problems/numbers-with-same-consecutive-differences

description

각 자릿수의 차이가 k 인 n 자리수 정수 배열을 반환하는 코드를 작성한다.

0 <= k <= 9
2 <= n <= 9

해결방안

k = 7 일때 다음에 나올 숫자는 아래와 같다.

1 - 8 o
2 - 9 o
3 - 10 x
4 - 11 x
5 - 12 x
6 - 13 x
7 - 0 o
8 - 1 o
9 - 2 o

즉 num + k <= 10 or 0 <= num - k

백트래킹 처럼 작성하려면 숫자를 문자로 변환하고 마지막엔 숫자로 변환한다.
"""

class Solution:
    def numsSameConsecDiff(self, n: int, k: int) -> List[int]:
        def backtrack(num, path):
            if len(path) == n:
                answer.append(int(''.join(path[:])))
                return
            
            if k == 0:
                path.append(str(num))
                backtrack(num, path)
                path.pop()
                return 

            if num + k < 10:
                path.append(str(num + k))
                backtrack(num + k, path)
                path.pop()
            
            if num - k >= 0:
                path.append(str(num - k))
                backtrack(num - k, path)
                path.pop()
            
                
        answer = []
        for num in range(1, 10):
            backtrack(num, [str(num)])
        return answer
