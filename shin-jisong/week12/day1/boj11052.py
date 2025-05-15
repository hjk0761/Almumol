import sys

n = int(sys.stdin.readline())
arr = list(map(int, sys.stdin.readline().strip().split()))

ans = [1] * n

for i in range(1, n):
    for j in range(i):
        if arr[i] > arr[j]:
            ans[i] = max(ans[i], ans[j] + 1)
print(max(ans))
