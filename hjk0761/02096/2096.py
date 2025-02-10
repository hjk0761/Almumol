import sys

n = int(input())

_max = [0, 0, 0]
_min = [0, 0, 0]

for i in range(n):
    line = list(map(int, sys.stdin.readline().strip().split()))
    _max = [line[0] + max(_max[:2]), line[1] + max(_max), line[2] + max(_max[1:])]
    _min = [line[0] + min(_min[:2]), line[1] + min(_min), line[2] + min(_min[1:])]

print(max(_max), min(_min))
