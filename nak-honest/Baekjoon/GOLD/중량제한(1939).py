import sys
from heapq import heappop
from heapq import heappush

N, M = map(int, input().split())

adj = [[] for _ in range(N)]

for _ in range(M):
    A, B, C = map(int, sys.stdin.readline().split())
    adj[A-1].append((C, B-1))
    adj[B-1].append((C, A-1))

P, Q = map(int, input().split())
P -= 1
Q -= 1

def dijkstra(w):
    d_adj = [[] for _ in range(N)]

    for i in range(N):
        for d, j in adj[i]:
            if d >= w:
                d_adj[i].append((d, j))

    heap = []
    visited = [False] * N
    heappush(heap, (0, P))
    dist = [sys.maxsize] * N
    dist[P] = 0

    while heap:
        d, node = heappop(heap)

        if node == Q:
            return True

        if visited[node]:
            continue
        visited[node] = True

        for i_d, i in d_adj[node]:
            if d + i_d < dist[i]:
                dist[i] = d + i_d
                heappush(heap, (dist[i], i))
    return False

k = 0

for i in range(N):
    for d, j in adj[i]:
        k = max(k, d)

cur = 0
diff = k

while diff >= 1:
    diff //= 2
    if dijkstra(cur + diff):
        cur += diff
        continue

while dijkstra(cur + 1):
    cur += 1

print(cur)
