import sys, heapq
def input(): return sys.stdin.readline().strip()

n, m = map(int, input().split())
c = [int(input()) for _ in range(n)]
graph = [[] for _ in range(n)]
for i in range(n):
    l = list(map(int, input().split()))
    for j in range(n):
        if l[j] > 0:
            graph[i].append((l[j], j))

def dijk(start, end):
    q = [(0, 0, start)]
    visited = [False for _ in range(n)]
    distance = [(sys.maxsize, sys.maxsize) for _ in range(n)]
    distance[0] = (0, 0)
    while q:
        transfer, weight, cur = heapq.heappop(q)
        if visited[cur]:
            continue
        visited[cur] = True
        for w, next in graph[cur]:
            if visited[next]:
                continue
            new_transfer = transfer + (0 if c[next] == c[cur] else 1)
            new_weight = distance[cur][1] + w
            if new_transfer > distance[next][0]:
                continue
            if new_transfer <  distance[next][0]:
                distance[next] = (new_transfer, new_weight)
                heapq.heappush(q, (new_transfer, new_weight, next))
            else:
                if new_weight <  distance[next][1]:
                    distance[next] = (new_transfer, new_weight)
                    heapq.heappush(q, (new_transfer, new_weight, next))
    return distance[end]

print(*dijk(0, m))
