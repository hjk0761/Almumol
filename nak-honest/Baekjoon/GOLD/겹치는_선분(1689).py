import sys

N = int(input())

points = []

for _ in range(N):
    s, e = map(int, sys.stdin.readline().split())
    points.append((e, 0))
    points.append((s, 1))

points.sort()

count = 0
answer = 0

for point, se in points:
    if se == 0:
        count -= 1
    else:
        count += 1
        answer = max(answer, count)

print(answer)

