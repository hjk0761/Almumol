import sys

def add(a, b):
    if a == sys.maxsize or b == sys.maxsize:
        return sys.maxsize
    return a + b

N, M = map(int, input().split())

W = [[sys.maxsize] * N for _ in range(N)]

for _ in range(M):
    a, b = map(int, sys.stdin.readline().split())
    W[a-1][b-1] = 1

for k in range(N):
    for i in range(N):
        for j in range(N):
            W[i][j] = min(W[i][j], add(W[i][k], W[k][j]))


answer = 0

for i in range(N):
    count = 0
    for j in range(N):
        if i == j:
            continue
        if W[i][j] != sys.maxsize or W[j][i] != sys.maxsize:
            count += 1
    if count == N - 1:
        answer += 1

print(answer)

'''
자기보다 작은 애들, 자기보다 큰 애들 전부 알면 됨.
-> 즉 모든 노드와 연결되어 있어야 함.
-> 플로이드 와샬 돌려서, 모든 노드와 연결되어 있는지 하나씩 확인하면 됨.
'''
