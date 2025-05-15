N, K = map(int, input().split())

dp = [[0] * (N + 1) for _ in range(K + 1)]

for j in range(N + 1):
    dp[1][j] = 1

for i in range(2, K + 1):
    for j in range(N + 1):
        for k in range(j + 1):
            dp[i][j] += dp[i-1][k]
            dp[i][j] %= 1_000_000_000
print(dp[K][N])

'''
dp[i][j] : i개의 수로 j를 만드는 경우의 수
dp[i][j] = dp[i-1][0] + dp[i-1][1] + ... + dp[i-1][j]
'''
