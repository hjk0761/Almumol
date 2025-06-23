import sys
def input(): return sys.stdin.readline().strip()

g = int(input())
p = int(input())

planes = [int(input()) for _ in range(p)]
result = 0
parent = [i for i in range(g+1)]

def find(node):
    if parent[node] == node:
        return node
    parent[node] = find(parent[node])
    return parent[node]

def union(i, j):
    pi, pj = find(i), find(j)
    parent[max(pi, pj)] = parent[min(pi, pj)]

def possible(plane):
    cur = find(plane)
    if cur == 0:
        return False
    union(plane, cur-1)
    return True

for plane in planes:
    if possible(plane):
        result += 1
    else:
        break
print(result)
