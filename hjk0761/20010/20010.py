import sys, heapq
def input(): return sys.stdin.readline().strip()

n, k = map(int, input().split())
edges = []
for _ in range(k):
    a, b, c = map(int, input().split())
    heapq.heappush(edges, (c, a, b))

parent = [i for i in range(n)]

def find(node):
    if parent[node] == node:
        return parent[node]
    parent[node] = find(parent[node])
    return parent[node]

def union(a, b):
    a = find(a)
    b = find(b)
    parent[max(a, b)] = parent[min(a, b)]

count = 0
s = 0
graph = [[] for _ in range(n)]

while count < n-1:
    c, a, b = heapq.heappop(edges)
    if find(a) != find(b):
        union(a, b)
        count += 1
        s += c
        graph[a].append((c, b))
        graph[b].append((c, a))

def find():
    pos, _max = -1, -1
    stack = []
    stack.append((0, 0))
    visited = [False for _ in range(n)]
    while stack:
        cur, d = stack.pop()
        if visited[cur]:
            continue
        visited[cur] = True
        if d > _max:
            _max = d
            pos = cur
        for cost, next in graph[cur]:
            if visited[next]:
                continue
            stack.append((next, d + cost))
    return pos

def find_dist(s):
    _max = -1
    stack = []
    stack.append((s, 0))
    visited = [False for _ in range(n)]
    while stack:
        cur, d = stack.pop()
        if visited[cur]:
            continue
        visited[cur] = True
        if d > _max:
            _max = d
        for cost, next in graph[cur]:
            if visited[next]:
                continue
            stack.append((next, d + cost))
    return _max

print(s)
print(find_dist(find()))
