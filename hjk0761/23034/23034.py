import sys
from collections import deque
def input(): return sys.stdin.readline().strip()

n, m = map(int, input().split())
edges = [list(map(int, input().split())) for _ in range(m)]
edges.sort(key = lambda x: x[2])

parent = [i for i in range(n+1)]

def find(x):
    if parent[x] != x:
        parent[x] = find(parent[x])
    return parent[x]

def union(x, y):
    xx, yy = find(x), find(y)
    if xx < yy:
        parent[yy] = xx
    else:
        parent[xx] = yy
    return
graph = [[] for _ in range(n+1)]
idx = 0
mst = 0
total = 0
while True:
    if mst == n-1:
        break
    if idx >= m:
        break
    temp = edges[idx]
    if find(temp[0]) != find(temp[1]):
        union(temp[0], temp[1])
        graph[temp[0]].append((temp[2], temp[1]))
        graph[temp[1]].append((temp[2], temp[0]))
        total += temp[2]
        mst += 1
    idx += 1
def find(x, y):
    visited = [False for _ in range(n+1)]
    q = deque()
    q.append((0, x))
    while q:
        d, cur = q.popleft()
        if cur == y:
            return d
        if visited[cur]:
            continue
        visited[cur] = True
        for dist, next in graph[cur]:
            if visited[next]:
                continue
            q.append((max(d, dist), next))

def solve(x, y):
    max_cost = find(x, y)
    return total - max_cost

result = []
q = int(input())
for _ in range(q):
    x, y = map(int, input().split())
    result.append(solve(x, y))

for re in result:
    print(re)
