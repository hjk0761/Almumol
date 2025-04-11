import sys
input = sys.stdin.readline

n, m = map(int, input().strip().split())
a = list(map(int, input().strip().split()))

prefixSum = [0 for _ in range(n+1)]
for i in range(n):
    prefixSum[i+1] = prefixSum[i] + a[i]

remainder = dict()
for i in range(n+1):
    r = prefixSum[i] % m
    if r not in remainder.keys():
        remainder[r] = 1
    else:
        remainder[r] += 1
result = 0
for re in remainder.values():
    result += re * (re-1) // 2
print(result)
