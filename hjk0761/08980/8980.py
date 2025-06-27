import sys
def input(): return sys.stdin.readline().strip()

n, c = map(int, input().split())
m = int(input())
box = [list(map(int, input().split())) for _ in range(m)]
box.sort(key = lambda x: x[1])

truck = [c for _ in range(n)]
result = 0

for l, r, b in box:
    count = c
    for i in range(l, r):
        if count >= min(truck[i], b):
            count = min(truck[i], b)
    for i in range(l, r):
        truck[i] -= count
    result += count
print(result)
