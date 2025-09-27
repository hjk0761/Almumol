import sys, heapq
def input(): return sys.stdin.readline().strip()

n, m = map(int, input().split())
graph = [[] for _ in range(n)]
for _ in range(m):
    a, b, d = map(int, input().split())
    graph[a-1].append((d, b-1))
    graph[b-1].append((d, a-1))

def dijk(start):
    q = []
    q.append((0, start))
    distance = [sys.maxsize for _ in range(n)]
    distance[start] = 0
    visited = [False for _ in range(n)]
    while q:
        _, cur = heapq.heappop(q)
        if visited[cur]:
            continue
        visited[cur] = True
        for dist, next in graph[cur]:
            if visited[next]:
                continue
            new_dist = distance[cur] + dist
            if distance[next] > new_dist:
                distance[next] = new_dist
                heapq.heappush(q, (new_dist, next))
    return distance

def dijk2(start):
    q = []
    q.append((0, start, 0))
    distance = [[sys.maxsize, sys.maxsize] for _ in range(n)]
    distance[start] = [0, sys.maxsize]
    visited = [[False, False] for _ in range(n)]
    while q:
        _, cur, count = heapq.heappop(q)
        if visited[cur][count]:
            continue
        visited[cur][count] = True
        for dist, next in graph[cur]:
            if visited[next][(count+1)%2]:
                continue
            new_dist = distance[cur][count] + (dist/2 if count == 0 else dist*2)
            if distance[next][(count+1)%2] > new_dist:
                distance[next][(count+1)%2] = new_dist
                heapq.heappush(q, (new_dist, next, (count+1)%2))
    return [min(x) for x in distance]

f_dist = dijk(0)
w_dist = dijk2(0)
result = 0
for i in range(n):
    if f_dist[i] < w_dist[i]:
        result += 1
print(result)
