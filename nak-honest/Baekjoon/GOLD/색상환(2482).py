N = int(input())
K = int(input())

dp = [[0] * (N + 1) for _ in range(N + 1)]

for i in range(1, N + 1):
    dp[i][1] = i
    if i % 2 == 0:
        dp[i][i // 2] = 2

for i in range(5, N + 1):
    for j in range(2, N + 1):
        if j >= (i + 1) // 2:
            break

        dp[i][j] = (dp[i - 1][j] + dp[i - 2][j - 1]) % 1_000_000_003

print(dp[N][K])
