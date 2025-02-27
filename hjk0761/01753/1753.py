import sys, heapq
from collections import deque

v, e = map(int, input().split())
k = int(input())

graph = [[] for _ in range(v+1)]

for _ in range(e):
    uu, vv, w = map(int, sys.stdin.readline().strip().split())
    heapq.heappush(graph[uu], (w, vv))

def dijk(start):
    visited = [False for _ in range(v+1)]
    distance = [sys.maxsize for _ in range(v+1)]
    distance[start] = 0
    q = []
    q.append((0, start))
    while q:
        _, cur = heapq.heappop(q)
        visited[cur] = True
        for weight, next in graph[cur]:
            if visited[next]:
                continue
            if distance[next] > weight + distance[cur]:
                distance[next] = weight + distance[cur]
                heapq.heappush(q, (distance[next], next))
    return distance

distance = dijk(k)

for i in range(1, v+1):
    print(distance[i] if distance[i] < sys.maxsize else "INF")
