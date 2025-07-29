import sys, heapq
from collections import deque
def input(): return sys.stdin.readline().strip()

n, m = map(int, input().split())
restaurant = list(map(int, input().split()))
cafe = list(map(int, input().split()))

graph = [[] for _ in range(n+1)]
for _ in range(m):
    u, v, w = map(int, input().split())
    if u == v:
        continue
    graph[u].append((w, v))
    graph[v].append((w, u))

reachable = set()
qq = deque()
qq.append(1)
while qq:
    cur = qq.popleft()
    if cur in reachable:
        continue
    reachable.add(cur)
    for weight, next in graph[cur]:
        if next in reachable:
            continue
        qq.append(next)

rest, caf, idxR, idxC = 1000000001, 1000000001, -1, -1
for i in range(n):
    if (i+1) not in reachable:
        continue
    if restaurant[i] != 0:
        if restaurant[i] < rest:
            rest = restaurant[i]
            idxR = i+1
    if cafe[i] != 0:
        if cafe[i] < caf:
            caf = cafe[i]
            idxC = i+1

def dijk(start):
    distance = [sys.maxsize for _ in range(n+1)]
    distance[start] = 0
    q = []
    q.append((0, start))
    while q:
        d, cur = heapq.heappop(q)
        if distance[cur] < d:
            continue
        for weight, next in graph[cur]:
            if distance[next] > weight + distance[cur]:
                distance[next] = weight + distance[cur]
                heapq.heappush(q, (distance[next], next))
    return distance

result = 0
dist = dijk(1)
result += dist[idxR]
result += dist[idxC]
dist = dijk(idxR)
result += dist[idxC]
print(result)
