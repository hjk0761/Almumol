import sys
import heapq

n = int(input())

graph = [[] for _ in range(n+1)]

for _ in range(n-1):
    u, v, d = map(int, sys.stdin.readline().strip().split())
    graph[u].append((d, v))
    graph[v].append((d, u))

def dijk(start):
    q = []
    visited = [False for _ in range(n+1)]
    distance = [sys.maxsize for _ in range(n+1)]
    distance[0] = -1
    q.append((0, start))
    distance[start] = 0
    while q:
        _, cur = heapq.heappop(q)
        visited[cur] = True
        for weight, next in graph[cur]:
            if visited[next]:
                continue
            distance[next] = min(distance[next], distance[cur] + weight)
            heapq.heappush(q, (distance[next], next))
    _max = max(distance)
    return distance.index(_max), _max

edge, _ = dijk(1)
_, diameter = dijk(edge)

print(diameter)
