import sys, heapq
from collections import deque
def input(): return sys.stdin.readline().strip()

n, m = map(int, input().split())
graph = [[] for _ in range(n+1)]
for _ in range(m):
    a, b, c = map(int, input().split())
    graph[a].append((c, b))
    graph[b].append((c, a))

def dijk():
    distance = [sys.maxsize for _ in range(n+1)]
    visited = [False for _ in range(n+1)]
    distance[1] = 0
    parent = [i for i in range(n+1)]
    q = [(0, 1)]
    while q:
        _, cur = heapq.heappop(q)
        if visited[cur]:
            continue
        visited[cur] = True
        for weight, next in graph[cur]:
            if visited[next]:
                continue
            new_distance = distance[cur] + weight
            if distance[next] <= new_distance:
                continue
            distance[next] = new_distance
            heapq.heappush(q, (new_distance, next))
            parent[next] = cur
    return parent

def find(parent):
    path = []
    visited = set()
    q = deque()
    q.append(1)
    while q:
        cur = q.popleft()
        if cur in visited:
            continue
        visited.add(cur)
        for i in range(len(parent)):
            if i not in visited and parent[i] == cur:
                q.append(i)
                path.append((cur, i))
    return path

parent = dijk()
path = find(parent)

print(len(path))
for u, v in path:
    print(u, v)
