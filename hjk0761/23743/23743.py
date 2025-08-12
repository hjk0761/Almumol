import sys, heapq
def input(): return sys.stdin.readline().strip()

n, m = map(int, input().split())
edge = []
for _ in range(m):
    a, b, c = map(int, input().split())
    heapq.heappush(edge, (c, a, b))
exits = list(map(int, input().split()))
for i in range(n):
    heapq.heappush(edge, (exits[i], 0, i+1))

parent = [i for i in range(n+1)]

def find(node):
    if parent[node] == node:
        return node
    parent[node] = find(parent[node])
    return parent[node]

def union(u, v):
    u = find(u)
    v = find(v)
    parent[max(u, v)] = min(u, v)

count, result = 0, 0

while edge:
    weight, _from, _to = heapq.heappop(edge)
    if find(_from) == find(_to):
        continue
    union(_from, _to)
    result += weight
    if count == n-1:
        break

print(result)
