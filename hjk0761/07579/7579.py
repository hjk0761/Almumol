import sys
input = sys.stdin.readline

n, m = map(int, input().strip().split())
weight = list(map(int, input().strip().split()))
cost = list(map(int, input().strip().split()))
c = sum(cost)

dp = [[0 for _ in range(c+1)] for _ in range(n+1)]

for i in range(1, n+1):
    for j in range(c+1):
        if j >= cost[i-1]:
            dp[i][j] = max(dp[i-1][j], dp[i-1][j-cost[i-1]] + weight[i-1])
        else:
            dp[i][j] = dp[i-1][j]

result = 0
for i in range(c+1):
    if dp[n][i] >= m:
        result = i
        break
print(result)