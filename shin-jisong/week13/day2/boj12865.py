import sys

n, k = map(int, sys.stdin.readline().rstrip().split())
items = []

for _ in range(n):
    w, v = map(int, sys.stdin.readline().rstrip().split())
    items.append((w, v))

ans = [0] * (k + 1)

for w, v in items:
    for i in range(k, w - 1, -1):
        ans[i] = max(ans[i], ans[i - w] + v)

print(ans[k])
