import sys
from collections import deque

for _ in range(int(input())):
    N, K = map(int, input().split())
    D = list(map(int, sys.stdin.readline().split()))
    inn = [set() for _ in range(N)]
    out = [set() for _ in range(N)]

    for _ in range(K):
        X, Y = map(int, sys.stdin.readline().split())
        X -= 1
        Y -= 1
        inn[Y].add(X)
        out[X].add(Y)

    W = int(input()) - 1
    cost = [0 for _ in range(N)]
    q = deque()

    for i in range(N):
        if not inn[i]:
            q.append(i)
            cost[i] = D[i]

    while q:
        node = q.popleft()

        if node == W:
            print(cost[node])
            break

        for next in out[node]:
            cost[next] = max(cost[next], cost[node] + D[next])
            inn[next].remove(node)
            if not inn[next]:
                q.append(next)
