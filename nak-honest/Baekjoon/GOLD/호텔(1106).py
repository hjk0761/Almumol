import sys

C, N = map(int, input().split())
cities = [[0, 0]] + [list(map(int, sys.stdin.readline().split())) for _ in range(N)]

dp = [[0] * (C + 100000) for _ in range(N+1)]

for i in range(1, N+1):
    for j in range(C + 100000):
        dp[i][j] = dp[i - 1][j]
        if j-cities[i][0] >= 0:
            dp[i][j] = max(dp[i][j], dp[i-1][j-cities[i][0]] + cities[i][1])
            dp[i][j] = max(dp[i][j], dp[i][j-cities[i][0]] + cities[i][1])

for j in range(C + 100000):
    if dp[N][j] >= C:
        print(j)
        break
