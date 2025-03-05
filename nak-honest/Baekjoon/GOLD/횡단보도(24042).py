import sys
from heapq import heappop
from heapq import heappush

N, M = map(int, input().split())

cycle = []
adj = [[] for _ in range(N)]

for i in range(M):
    # A에서 B로 바로 갔을 때 B에 도착하는 시간은 i + 1 분이다.
    A, B = map(int, sys.stdin.readline().split())
    A -= 1
    B -= 1
    cycle.append((A, B))
    adj[A].append((i, B))
    adj[B].append((i, A))

heap = []
dist = [sys.maxsize] * N
dist[0] = 0
v = [False] * N

heappush(heap, (0, 0))

while heap:
    d, node = heappop(heap)
    if node == N - 1:
        print(d)
        break
    if v[node]:
        continue

    v[node] = True

    for i, next in adj[node]:
        # xM + i < d <= (x + 1)M + i 를 만족하는 x를 찾는다.
        # 그러면 도착 next_d 는 (x + 1) * M + i + 1 이 된다.
        x = (d - i - 1) // M
        next_d = (x + 1) * M + i + 1

        if dist[next] > next_d:
            heappush(heap, (next_d, next))
