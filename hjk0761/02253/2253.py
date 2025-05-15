import sys
input = sys.stdin.readline

n, m = map(int, input().strip().split())
small = set(int(input().strip()) for _ in range(m))
dp = [[sys.maxsize for _ in range(151)] for _ in range(n+1)]
dp[1][1] = 0
if 2 not in small:
    dp[2][1] = 1

for rock in range(1, n):
    for speed in range(151):
        if dp[rock][speed] == sys.maxsize:
            continue
        for new_speed in [speed-1, speed, speed+1]:
            if new_speed == 0:
                continue
            if rock+speed > n:
                continue
            if rock+speed in small:
                continue
            dp[rock+speed][new_speed] = min(dp[rock+speed][new_speed], dp[rock][speed] + 1)
result = min(dp[n])
print(result if result < sys.maxsize else -1)
