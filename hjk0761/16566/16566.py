import sys, math
def input(): return sys.stdin.readline().strip()

n, m, k = map(int, input().split())
minsu = list(map(int, input().split()))
charsu = list(map(int, input().split()))

minsu.sort()

parent = [i for i in range(m)]

def find(node):
    if parent[node] != node:
        parent[node] = find(parent[node])
    return parent[node]

def union(i, j):
    if i >= m or j >= m:
        return
    pi, pj = find(i), find(j)
    parent[min(pi, pj)] = parent[max(pi, pj)]
    return

def binary(left, right, target):
    while left + 1 < right:
        mid = (left + right) // 2
        if minsu[mid] > target:
            right = mid
        else:
            left = mid
    return right

result = []

for d in charsu:
    idx = binary(-1, m, d)
    result.append(minsu[find(idx)])
    union(idx, parent[idx]+1)

for re in result:
    print(re)
