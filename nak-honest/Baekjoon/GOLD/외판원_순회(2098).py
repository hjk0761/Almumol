import sys

def add(bit, i):
    return bit | (1 << i)

def is_in(bit, i):
    return bit & (1 << i) > 0

def infinite_add(a, b):
    if a == sys.maxsize or b == sys.maxsize:
        return sys.maxsize

    return a + b

N = int(input())
W = [list(map(int, input().split())) for _ in range(N)]

for i in range(N):
    for j in range(N):
        if W[i][j] == 0:
            W[i][j] = sys.maxsize

D = [[-1] * (1 << (N + 1)) for _ in range(N)]

for i in range(1, N):
    D[i][0] = W[i][0]

def tps(i, visited):
    if visited == (1 << N) - 1:
        return W[i][0]

    if D[i][visited] != -1:
        return D[i][visited]

    D[i][visited] = sys.maxsize

    for j in range(1, N):
        if j == i or is_in(visited, j):
            continue

        D[i][visited] = min(D[i][visited], infinite_add(W[i][j], tps(j, add(visited, j))))

    return D[i][visited]
print(tps(0, 1))

'''
D[i][A] : vi 에서 시작해서 A의 모든 원소를 거쳐 v1으로 돌아가는데 드는 최소 비용
D[i][A] = min(W[i][j] + D[j][A-vj]) (vj in A)

D[i][{}] = W[i][1]

A -> 비트 마스킹으로 해결
'''

