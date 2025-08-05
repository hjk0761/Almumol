import sys
def input(): return sys.stdin.readline().strip()

n, k = map(int, input().split())
items = list(map(int, input().split()))
prefixSum = [0 for _ in range(n+2*k-1)]
for i in range(n):
    prefixSum[i+k] = prefixSum[i+k-1] + items[i]
for i in range(n+k, n+2*k-1):
    prefixSum[i] = prefixSum[i-1]
dp = [[-sys.maxsize for _ in range(2)] for _ in range(n+k)]
dp[1][0] = prefixSum[k] - prefixSum[0]
dp[1][1] = 0
for i in range(2, len(dp)):
    dp[i][0] = max(dp[i][0], dp[i-1][0] + prefixSum[i+k-1] - prefixSum[i+k-2])
    if i > k:
        dp[i][0] = max(dp[i][0], max(dp[i-k]) + prefixSum[i+k-1] - prefixSum[i-1])
    dp[i][1] = max(dp[i-1][0], dp[i-1][1])

print(max(dp[-1][0], dp[-1][1]))
