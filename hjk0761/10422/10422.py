import sys

t = int(input())
dp = [0 for _ in range(5001)]
result = []

dp[0] = 1
dp[2] = 1

for i in range(4, 5001):
    if i % 2 != 0:
        continue
    for j in range(i//2):
        dp[i] += (dp[i-(j+1)*2]*dp[j*2]) % 1_000_000_007
    dp[i] = dp[i] % 1_000_000_007

for _ in range(t):
    l = int(sys.stdin.readline().strip())
    result.append(dp[l])

for re in result:
    print(re)
