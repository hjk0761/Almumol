import sys, heapq
from collections import deque
input = sys.stdin.readline

n, m, k = map(int, input().strip().split())
graph = [[] for _ in range(n+1)]
for i in range(m):
    u, v, c = map(int, input().strip().split())
    heapq.heappush(graph[v], (c, u))
interview = list(map(int, input().strip().split()))
interview.sort()

def bfs(starts):
    q = deque()
    visited = [False for _ in range(n+1)]
    distance = [sys.maxsize for _ in range(n+1)]
    for start in starts:
        distance[start] = 0
        visited[start] = True
        q.append(start)
    while q:
        cur = q.popleft()
        for cost, next in graph[cur]:
            new_cost = distance[cur] + cost
            if new_cost >= distance[next]:
                continue
            visited[next] = True
            distance[next] = new_cost
            q.append(next)
    return distance

idx, value = -1, -1
result = bfs(interview)
for i in range(1, n+1):
    if i in interview:
        continue
    if result[i] > value:
        idx = i
        value = result[i]
print(idx)
print(value)
