import sys, heapq
def input(): return sys.stdin.readline().strip()

n = int(input())
r, d = map(int, input().split())
m = int(input())
graph = [[] for _ in range(n+1)]

for _ in range(m):
    h, t, e1, e2 = map(int, input().split())
    for i in range(n-h+1):
        graph[i+e1].append((t, i+e2))
        graph[i+e2].append((t, i+e1))

def solve(start, end):
    visited = [False for _ in range(n+1)]
    d = [sys.maxsize for _ in range(n+1)]
    q = []
    heapq.heappush(q, (0, start))
    if start != end:
        d[start] = 0
    while q:
        _, cur = heapq.heappop(q)
        if visited[cur]:
            continue
        visited[cur] = True
        for next_cost, next in graph[cur]:
            new_cost = d[cur] + next_cost
            if d[next] > new_cost:
                d[next] = new_cost
                heapq.heappush(q, (new_cost, next))
    return d[end]

result = solve(r, d)
print(result if result < sys.maxsize else -1)
