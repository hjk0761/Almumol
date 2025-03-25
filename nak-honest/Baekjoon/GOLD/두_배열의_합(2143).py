import sys

T = int(input())
n = int(input())
A = list(map(int, sys.stdin.readline().split()))
m = int(input())
B = list(map(int, sys.stdin.readline().split()))

A_s = [A[0]]
B_s = [B[0]]

for a in A[1:]:
    A_s.append(A_s[-1] + a)

for b in B[1:]:
    B_s.append(B_s[-1] + b)

A_sum = dict()

for i in range(n):
    for j in range(i, n):
        s = A_s[j]
        if i != 0:
            s -= A_s[i - 1]

        A_sum[s] = A_sum.get(s, 0) + 1

B_sum = dict()

for i in range(m):
    for j in range(i, m):
        s = B_s[j]
        if i != 0:
            s -= B_s[i - 1]

        B_sum[s] = B_sum.get(s, 0) + 1

answer = 0
for a in A_sum:
    b = T - a
    if b in B_sum:
        answer += A_sum[a] * B_sum[b]

print(answer)
