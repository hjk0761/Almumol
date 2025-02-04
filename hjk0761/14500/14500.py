import sys
n = int(input())

dp = [0 for _ in range(n+2)]

for i in range(n):
    day = i+1
    t, p = map(int, sys.stdin.readline().strip().split())
    dp[day] = max(dp[day], dp[day-1])
    if day + t <= n+1:
        dp[day+t] = max(dp[day+t], dp[day] + p)

print(max(dp))
