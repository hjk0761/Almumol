import sys

N = int(input())
nums = list(map(int, sys.stdin.readline().split()))

dp = [[0] * 21 for _ in range(N - 1)]

dp[0][nums[0]] = 1

for i in range(1, N - 1):
    a = nums[i]
    for k in range(21):
        if k - a >= 0:
            dp[i][k] += dp[i - 1][k - a]
        if k + a <= 20:
            dp[i][k] += dp[i - 1][k + a]

print(dp[-1][nums[-1]])
'''
dp[i][k] : i ~ j 의 수로 k를 만들어 내는 경우의 수
a = nums[j+1] 이라 할 때,
dp[i+1][k + a] += dp[i][k]
dp[i+1][k - a] += dp[i][k]
'''


