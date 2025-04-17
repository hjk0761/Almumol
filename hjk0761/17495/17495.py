import sys

n, m = map(int, input().split())

path = [list(map(int, sys.stdin.readline().strip().split())) for _ in range(n)]

dp = [[[0 for _ in range(3)] for _ in range(m)] for _ in range(n)]

for j in range(m):
    for k in range(3):
        dp[0][j][k] = path[0][j]

for j in range(m):
    dp[1][j][0] = sys.maxsize if j == 0 else dp[0][j-1][0] + path[1][j]
    dp[1][j][1] = dp[0][j][1] + path[1][j]
    dp[1][j][2] = sys.maxsize if j == m-1 else dp[0][j+1][2] + path[1][j]

for i in range(2, n):
    for j in range(m):
        dp[i][j][0] = sys.maxsize if j == 0 else min(dp[i-1][j-1][1], dp[i-1][j-1][2]) + path[i][j]
        dp[i][j][1] = min(dp[i-1][j][0], dp[i-1][j][2]) + path[i][j]
        dp[i][j][2] = sys.maxsize if j == m-1 else min(dp[i-1][j+1][0], dp[i-1][j+1][1]) + path[i][j]

print(min(min(line) for line in dp[n-1]))
