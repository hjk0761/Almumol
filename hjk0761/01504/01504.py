import sys, heapq

n, e = map(int, input().split())

graph = [[] for _ in range(n+1)]

for _ in range(e):
    s, e, d = map(int, sys.stdin.readline().strip().split())
    graph[s].append([d, e])
    graph[e].append([d, s])

def dijk(start, end):
    d = [sys.maxsize for _ in range(n+1)]
    q = []
    heapq.heappush(q, (0, start))
    d[start] = 0
    while q:
        _, cur = heapq.heappop(q)
        for weight, next in graph[cur]:
            if d[next] > d[cur] + weight:
                d[next] = d[cur] + weight
                heapq.heappush(q, (d[next], next))
    return d[end]

v1, v2 = map(int, input().split())

result = min(dijk(1, v1) + dijk(v1, v2) + dijk(v2, n), dijk(1, v2) + dijk(v2, v1) + dijk(v1, n))
print(result if result < sys.maxsize else -1)
