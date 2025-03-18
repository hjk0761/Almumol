import sys

n, k = map(int, sys.stdin.readline().strip().split())
keys = list(map(int, sys.stdin.readline().strip().split()))

_min, _max = keys[0], keys[0]
count = 0

for i in range(1, n):
    next = keys[i]
    if next < _min and _max - next >= k:
        count += 1
        _min, _max = next, next
    elif next > _max and next - _min >= k:
        count += 1
        _min, _max = next, next
    else:
        _min = min(_min, next)
        _max = max(_max, next)

print(count)
