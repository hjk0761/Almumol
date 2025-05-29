import sys
def input(): return sys.stdin.readline().strip()

n, m = map(int, input().split())
value = [0 for _ in range(n+1)]
for i in range(n):
    value[i+1] = int(input())

parent = [i for i in range(n+1)]

def find(node):
    if parent[node] == node:
        return node
    parent[node] = find(parent[node])
    return parent[node]

def ally(p, q):
    p, q = find(p), find(q)
    if p == q:
        return
    elif p > q:
        parent[q] = p
        value[p] += value[q]
        value[q] = 0
    else:
        parent[p] = q
        value[q] += value[p]
        value[p] = 0

def battle(p, q):
    p_parent, q_parent = find(p), find(q)
    if p_parent == q_parent:
        return
    if value[p_parent] == value[q_parent]:
        value[p_parent], value[q_parent] = 0, 0
        parent[p_parent], parent[q_parent] = 0, 0
    elif value[p_parent] > value[q_parent]:
        parent[q_parent] = p_parent
        value[p_parent] -= value[q_parent]
        value[q_parent] = 0
    else:
        parent[p_parent] = q_parent
        value[q_parent] -= value[p_parent]
        value[p_parent] = 0

for _ in range(m):
    o, p, q = map(int, input().split())
    if o == 1:
        ally(p, q)
    else:
        battle(p, q)

result = []
for i in range(1, n+1):
    if value[i] == 0:
        continue
    result.append(value[i])
result.sort()
print(len(result))
if len(result):
    print(*result)
