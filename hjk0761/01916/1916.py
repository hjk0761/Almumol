import sys, heapq

n = int(input())
m = int(input())

graph = [[] for _ in range(n+1)]

for _ in range(m):
    s, e, d = map(int, sys.stdin.readline().strip().split())
    graph[s].append((d, e))

def dijk(g, s, e):
    visited = [False for _ in range(n+1)]
    distance = [sys.maxsize for _ in range(n+1)]
    q = []
    q.append((0, s))
    distance[s] = 0
    while q:
        _, cur = heapq.heappop(q)
        visited[cur] = True
        if cur == e:
            return distance[e]
        for weight, next in g[cur]:
            if visited[next]:
                continue
            if distance[next] > distance[cur] + weight:
                distance[next] = distance[cur] + weight
                heapq.heappush(q, (distance[next], next))

start, end = map(int, sys.stdin.readline().strip().split())

print(dijk(graph, start, end))
