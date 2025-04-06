import sys
input = sys.stdin.readline

n = int(input().strip())
city = [list(map(int, input().strip().split())) for _ in range(n)]

dp = [[[0 for _ in range(n+1)] for _ in range(n+1)] for _ in range(3)]

dp[0][1][1] = 1 if city[0][0] == 0 else 0

for i in range(n):
    for j in range(n):
        if i == 0 and j == 0:
            continue
        cur = city[i][j]
        temp = max(dp[(cur+2)%3][i][j+1], dp[(cur+2)%3][i+1][j])
        dp[cur][i+1][j+1] = temp + 1 if temp > 0 else 0
        if cur == 0 and dp[cur][i+1][j+1] == 0:
            dp[cur][i+1][j+1] += 1
        dp[(cur+1)%3][i+1][j+1] = max(dp[(cur+1)%3][i][j+1], dp[(cur+1)%3][i+1][j])
        dp[(cur+2)%3][i+1][j+1] = max(dp[(cur+2)%3][i][j+1], dp[(cur+2)%3][i+1][j])

print(max(dp[0][n][n], dp[1][n][n], dp[2][n][n]))
