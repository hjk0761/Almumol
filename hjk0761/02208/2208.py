import sys
def input(): return sys.stdin.readline().strip()

n, m = map(int, input().split())
jewel = [int(input()) for _ in range(n)]

prefixSum = [0 for _ in range(n+1)]
for i in range(n):
    prefixSum[i+1] = prefixSum[i] + jewel[i]

partialMax = [0 for _ in range(n)]
for i in range(n-1, -1, -1):
    if i == n-1:
        partialMax[i] = prefixSum[i+1]
    else:
        partialMax[i] = max(partialMax[i+1], prefixSum[i+1])
_max = 0
for i in range(n-m+1):
    _max = max(_max, partialMax[i+m-1] - prefixSum[i])
print(_max)
