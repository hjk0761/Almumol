import sys

n = int(input())

files = [[] for _ in range(n)]

for i in range(n):
    files[i] = list(map(int, sys.stdin.readline().strip().split()))

_max = max(map(len, files))
checked = True

for i in range(1, _max+1):
    test = set()
    for j in range(n):
        sample = 0 if files[j][0] == -1 else files[j][0]
        for k in range(1, i):
            sample *= 10
            sample += 0 if ((len(files[j])-1 < k) or (files[j][k] == -1)) else files[j][k]
        test.add(sample)
    if len(test) != n:
        continue
    else:
        print(i)
        checked = False
        break

if checked:
    print(_max)
