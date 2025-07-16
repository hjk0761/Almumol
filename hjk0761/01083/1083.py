import sys
def input(): return sys.stdin.readline().strip()

n = int(input())
a = list(map(int, input().split()))
s = int(input())

for i in range(n):
    if s <= 0:
        break
    _max, idx = -1, -1
    for j in range(i, min(n, i + s + 1)):
        if a[j] > _max:
            _max = a[j]
            idx = j
    while idx != i and s > 0:
        a[idx], a[idx-1] = a[idx-1], a[idx]
        s -= 1
        idx -= 1

print(*a)
