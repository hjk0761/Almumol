import sys
from heapq import heappush
from heapq import heappop

def add(a, b):
    if a == sys.maxsize or b == sys.maxsize:
        return sys.maxsize

    return a + b

while True:
    N, M = map(int, input().split())
    if N == 0 and M == 0:
        break

    S, D = map(int, input().split())

    adj = [set() for _ in range(N)]

    for _ in range(M):
        U, V, P = map(int, sys.stdin.readline().split())
        adj[U].add((P, V))

    prev = [set() for _ in range(N)]
    dist = [sys.maxsize] * N
    visited = [False] * N
    dist[S] = 0

    heap = [(0, S)]

    while heap:
        d, node = heappop(heap)
        if node == D:
            break
        if visited[node]:
            continue
        visited[node] = True

        for next_d, next_node in adj[node]:
            sum_d = add(d, next_d)
            if sum_d < dist[next_node]:
                dist[next_node] = sum_d
                heappush(heap, (sum_d, next_node))
                prev[next_node].clear()
                prev[next_node].add(node)
            elif sum_d == dist[next_node]:
                prev[next_node].add(node)

    removed = set()
    stack = []
    visited = [False] * N
    visited[D] = True

    for i in prev[D]:
        stack.append((i, D))

    while stack:
        i, j = stack.pop()
        removed.add((i, j))
        if i == S:
            continue

        if visited[i]:
            continue
        visited[i] = True

        for next_i in prev[i]:
            stack.append((next_i, i))

    dist = [sys.maxsize] * N
    visited = [False] * N
    dist[S] = 0

    heap = [(0, S)]

    answer = -1

    while heap:
        d, node = heappop(heap)

        if node == D:
            answer = d
            break

        if visited[node]:
            continue
        visited[node] = True

        for next_d, next_node in adj[node]:
            if (node, next_node) in removed:
                continue
            sum_d = add(d, next_d)
            if sum_d < dist[next_node]:
                dist[next_node] = sum_d
                heappush(heap, (sum_d, next_node))

    print(answer)
