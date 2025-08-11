import sys
from collections import deque
def input(): return sys.stdin.readline().strip()

n, k, m = map(int, input().split())
graph = [[] for _ in range(n+m+1)]
for i in range(m):
    hypertube = list(map(int, input().split()))
    for h in hypertube:
        graph[n+i+1].append(h)
        graph[h].append(n+i+1)

def solve(start, end):
    visited = [-1 for _ in range(n+m+1)]
    q = deque()
    q.append(start)
    visited[start] = 1
    while q:
        cur = q.popleft()
        for next in graph[cur]:
            if visited[next] == -1:
                visited[next] = visited[cur] + 1
                q.append(next)
    if visited[end] != -1:
        return visited[end] // 2 + 1
    return visited[end]

print(solve(1, n))
