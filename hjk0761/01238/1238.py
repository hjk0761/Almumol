import sys, heapq

n, m, x = map(int, input().split())

graph_forward = [[] for _ in range(n+1)]
graph_backward = [[] for _ in range(n+1)]

for _ in range(m):
    u, v, d = map(int, sys.stdin.readline().strip().split())
    graph_forward[u].append((d, v))
    graph_backward[v].append((d, u))

def dijk(s, isForward):
    q = []
    q.append((0, s))
    visited = [False for _ in range(n+1)]
    distance = [sys.maxsize for _ in range(n+1)]
    distance[s] = 0
    while q:
        _, cur = heapq.heappop(q)
        visited[cur] = True
        if isForward:
            target_graph = graph_forward
        else:
            target_graph = graph_backward
        for weight, next in target_graph[cur]:
            if visited[next]:
                continue
            distance[next] = min(distance[next], distance[cur] + weight)
            heapq.heappush(q, (distance[next], next))
    return distance

forward = dijk(x, True)
backward = dijk(x, False)

result = -1

for i in range(1, n+1):
    result = max(result, forward[i] + backward[i])

print(result)
