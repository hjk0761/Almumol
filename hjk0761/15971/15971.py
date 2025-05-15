import sys, heapq
input = sys.stdin.readline

n, s, e = map(int, input().strip().split())
graph = [[] for _ in range(n+1)]
for _ in range(n-1):
    u, v, cost = map(int, input().strip().split())
    graph[u].append((cost, v))
    graph[v].append((cost, u))

def dijkstra(start):
    visited = [False for _ in range(n+1)]
    visited[start] = True
    distance = [sys.maxsize for _ in range(n+1)]
    distance[start] = 0
    path = [(-1, -1) for _ in range(n+1)]
    q = [(0, start)]
    while q:
        _, cur = heapq.heappop(q)
        for cost, next in graph[cur]:
            new_cost = cost + distance[cur]
            if distance[next] > new_cost:
                distance[next] = new_cost
                heapq.heappush(q, (new_cost, next))
                path[next] = (cur, cost)
    return distance, path

def find_longest_path(start, end, path):
    _max = 0
    cur = end
    while cur != start:
        _max = max(_max, path[cur][1])
        cur = path[cur][0]
    return _max
        

def solve():
    distance, path = dijkstra(s)
    print(distance[e] - find_longest_path(s, e, path))

solve()
