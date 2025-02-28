import sys
from heapq import heappop
from heapq import heappush


def find_parent(i):
    while i != union[i]:
        i = union[i]

    return i

N, M = map(int, input().split())
edges = []
union = [i for i in range(N + 1)]
depth = [1] * (N + 1)

for _ in range(M):
    u, v, t = map(int, sys.stdin.readline().split())
    heappush(edges, (t, u, v))

answer = 1
count = 0
while edges and count < N - 1:
    t, u, v = heappop(edges)
    p_u = find_parent(u)
    p_v = find_parent(v)

    if p_u == p_v:
        continue

    if t > count + 1:
        break

    if depth[p_u] > depth[p_v]:
        union[p_v] = p_u
    elif depth[p_u] < depth[p_v]:
        union[p_u] = p_v
    else:
        union[p_v] = p_u
        depth[p_u] += 1

    count += 1
    answer = count + 1

print(answer)


