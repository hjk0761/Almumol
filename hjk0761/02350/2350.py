import sys, heapq
from collections import deque
def input(): return sys.stdin.readline().strip()

n, m, k = map(int, input().split())
edges = []
for _ in range(m):
    i, j, w = map(int, input().split())
    heapq.heappush(edges, (-w, i, j))

parent = [i for i in range(n+1)]
graph = [[] for _ in range(n+1)]

def find(node):
    if parent[node] == node:
        return node
    parent[node] = find(parent[node])
    return parent[node]

def union(i, j):
    pi, pj = find(i), find(j)
    parent[max(pi, pj)] = parent[min(pi, pj)]

while edges:
    width, i, j = heapq.heappop(edges)
    width *= -1
    if find(i) == find(j):
        continue
    union(i, j)
    graph[i].append((width, j))
    graph[j].append((width, i))

result = []

def solve(_from, _to):
    visited = [False for _ in range(n+1)]
    visited[_from] = True
    q = deque()
    q.append((sys.maxsize, _from))
    while q:
        width, cur = q.popleft()
        if cur == _to:
            return width
        visited[cur] = True
        for next_width, next in graph[cur]:
            if visited[next]:
                continue
            q.append((min(width, next_width), next))
    return

for _ in range(k):
    _from, _to = map(int, input().split())
    result.append(solve(_from, _to))

for re in result:
    print(re)
