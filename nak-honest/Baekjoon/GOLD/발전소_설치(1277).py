import sys
from heapq import heappush
from heapq import heappop

N, W = map(int, input().split())
M = float(input())

bal = [tuple(map(int, sys.stdin.readline().split())) for _ in range(N)]
lines = {tuple(map(int, sys.stdin.readline().split())) for _ in range(W)}

adj = [[] for _ in range(N)]

for a, b in lines:
    a -= 1
    b -= 1
    adj[a].append((0, b))
    adj[b].append((0, a))

for i in range(N):
    for j in range(i+1, N):
        if (i+1, j+1) in lines or (j+1, i+1) in lines:
            continue
        length = ((bal[i][0] - bal[j][0]) ** 2 + (bal[i][1] - bal[j][1]) ** 2) ** 0.5
        if length > M:
            continue
        adj[i].append((length, j))
        adj[j].append((length, i))

heap = []
visited = [False] * N
dist = [sys.maxsize] * N
visited[0] = True
dist[0] = 0

for l, node in adj[0]:
    heappush(heap, (l, node))
    dist[node] = l

while heap:
    l, node = heappop(heap)

    if visited[node]:
        continue
    visited[node] = True
    if node == N - 1:
        print(int(l * 1000))
        break

    for next_l, next in adj[node]:
        if l + next_l < dist[next]:
            dist[next] = l + next_l
            heappush(heap, (l + next_l, next))
