import sys
from bisect import bisect_left
from bisect import bisect_right


n = int(input())
A = []
B = []
C = []
D = []

for _ in range(n):
    a, b, c, d = map(int, sys.stdin.readline().split())
    A.append(a)
    B.append(b)
    C.append(c)
    D.append(d)

ab = []
cd = dict()

for i in range(n):
    for j in range(n):
        ab.append(A[i] + B[j])
        s = -C[i] - D[j]
        cd[s] = cd.get(s, 0) + 1

answer = 0

for i in range(len(ab)):
    if ab[i] in cd:
        answer += cd[ab[i]]

print(answer)
