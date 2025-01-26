import sys

n = int(input())

meeting = []
count = 0

meeting = [list(map(int, sys.stdin.readline().strip().split())) for _ in range(n)]
meeting.sort(key=lambda x: (x[1], x[0]))

s, e = meeting[0]
count = 1

for i in range(1, n):
    if meeting[i][0] >= e:
        count += 1
        s, e = meeting[i][0], meeting[i][1]

print(count)
