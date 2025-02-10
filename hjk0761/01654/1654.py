import sys

k, n = map(int, input().split())

wire = [int(sys.stdin.readline().strip()) for _ in range(k)]

def decision(mid):
    count = 0
    for i in range(k):
        count += wire[i] // mid
    if count < n:
        return True
    return False

s, e = 1, 2**32
while s <= e:
    mid = (s + e) // 2
    if decision(mid):
        e = mid - 1
    else:
        s = mid + 1

print((s + e)//2)
