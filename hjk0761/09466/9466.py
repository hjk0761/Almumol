import sys
from collections import deque
input = sys.stdin.readline

def dfs(graph, node, visited):
    trace = deque()
    trace.append(node)
    visited[node] = True
    next = graph[node-1]
    while not visited[next]:
        visited[next] = True
        trace.append(next)
        next = graph[next-1]
    while trace and trace[0] != next:
        trace.popleft()
    return len(trace)

def find(n, forward):
    visited = [False for _ in range(n+1)]
    result = n
    for node in range(1, n+1):
        if visited[node]:
            continue
        result -= dfs(forward, node, visited)
    return result

def solve():
    t = int(input().strip())
    result = []

    for _ in range(t):
        n = int(input().strip())
        forward = list(map(int, input().strip().split()))
        result.append(find(n, forward))

    for re in result:
        print(re)

solve()
