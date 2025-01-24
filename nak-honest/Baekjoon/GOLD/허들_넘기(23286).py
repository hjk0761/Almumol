from copy import deepcopy
import sys

N, M, T = map(int, input().split())

W = [[sys.maxsize] * N for _ in range(N)]
for _ in range(M):
    u, v, h = map(int, sys.stdin.readline().split())
    u -= 1
    v -= 1
    W[u][v] = min(W[u][v], h)

for k in range(N):
    for i in range(N):
        for j in range(N):
            W[i][j] = min(W[i][j], max(W[i][k], W[k][j]))

for i in range(N):
    for j in range(N):
        if W[i][j] == sys.maxsize:
            W[i][j] = -1

answer = []
for _ in range(T):
    s, e = map(int, sys.stdin.readline().split())
    s -= 1
    e -= 1

    answer.append(W[s][e])

print(*answer, sep='\n')


