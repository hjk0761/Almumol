import sys
input = sys.stdin.readline

n, s, e = map(int, input().strip().split())
graph = [[] for _ in range(n+1)]
for _ in range(n-1):
    u, v = map(int, input().strip().split())
    graph[u].append(v)
    graph[v].append(u)

def dfs(s, parent):
    q = [s]
    visited = [False for _ in range(n+1)]
    visited[s] = True
    while q:
        cur = q.pop()
        for next in graph[cur]:
            if visited[next]:
                continue
            visited[next] = True
            parent[next] = cur
            q.append(next)

def solve():
    parent = [i for i in range(n+1)]
    dfs(s, parent)

    path = [e]
    while path[-1] != parent[path[-1]]:
        path.append(parent[path[-1]])
    path.reverse()
    visited = [False for _ in range(n+1)]

    for i in range(len(path)-1):
        cur = path[i]
        if i % 2 == 0:
            visited[cur] = True
            continue
        for next in graph[cur]:
            if visited[next]:
                continue
            if next == path[i+1]:
                continue
            return "Second"
    return "First"
print(solve())
