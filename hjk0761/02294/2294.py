import sys

n, k = map(int, input().split())

coins = []

for _ in range(n):
    coin = int(sys.stdin.readline().strip())
    if coin > k or coin in coins:
        continue
    coins.append(coin)

dp = [sys.maxsize for _ in range(k+1)]

for coin in coins:
    dp[coin] = 1

for i in range(1, k+1):
    for coin in coins:
        if i > coin:
            dp[i] = min(dp[i], dp[i - coin] + 1)

print(dp[k] if dp[k] != sys.maxsize else -1)
