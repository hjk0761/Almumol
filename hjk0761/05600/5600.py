import sys

a, b, c = map(int, input().split())

n = int(input())

tests = [[] for _ in range(n)]

for i in range(n):
    tests[i] = list(map(int, sys.stdin.readline().strip().split()))

result = [2 for _ in range(1+a+b+c)]

for ai, bi, ci, test in tests:
    if test == 1:
        result[ai] = 1
        result[bi] = 1
        result[ci] = 1

while True:
    changed = False
    for ai, bi, ci, test in tests:
        if test == 1:
            continue
        if result[ai] != 2 and result[bi] != 2 and result[ci] != 2:
            continue
        if result[ai]*result[bi] == 1:
            result[ci] = 0
            changed = True
        elif result[ai]*result[ci] == 1:
            result[bi] = 0
            changed = True
        elif result[bi]*result[ci] == 1:
            result[ai] = 0
            changed = True
    if not changed:
        break

for i in range(len(result)):
    if i == 0:
        continue
    print(result[i])
