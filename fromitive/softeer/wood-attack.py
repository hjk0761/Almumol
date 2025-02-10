""" 
title: 나무 공격
link : https://softeer.ai/practice/9657
"""

import sys

def solve(N, M, matrix, L1, R1, L2, R2):
    totalSum = 0
    for n in range(N):
        nSum = sum(matrix[n])
        if L1 - 1 <= n < R1:
            nSum -= 1
        if L2 - 1 <= n < R2:
            nSum -= 1
        if nSum < 0:
            nSum = 0
        totalSum += nSum
    return totalSum
N, M = map(int, input().split())
matrix = []

for _ in range(N):
    matrix.append(list(map(int, input().split())))
L1, R1 = map(int, input().split())
L2, R2 = map(int, input().split())

print(solve(N,M,matrix,L1,R1,L2,R2))