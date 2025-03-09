import sys

n, m, q = map(int, input().split())

rows = [0 for _ in range(n)]
columns = [0 for _ in range(m)]

for _ in range(q):
    method, target, value = map(int, sys.stdin.readline().strip().split())
    if method == 1:
        rows[target-1] += value
    else:
        columns[target-1] += value

for i in range(n):
    for j in range(m):
        print(rows[i] + columns[j], end=' ')
    print()
