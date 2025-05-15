import sys
input = sys.stdin.readline

s = input().strip()
n = len(s)
def solve():
    if len(s) == 0:
        return 0
    dp = [0 for _ in range(n)]
    for i in range(n):
        if i == 0:
            if s[i] == '0':
                return 0
            dp[i] = 1
            continue
        if i == 1:
            if int(s[:2]) == 0:
                return 0
            if int(s[:2]) > 26:
                if s[i] == '0':
                    return 0
                dp[i] = dp[i-1]
                continue
            dp[i] = dp[i-1] + (1 if s[i] != '0' else 0)
            continue
        if int(s[i-1:i+1]) == 0:
            return 0
        if int(s[i-1:i+1]) > 26:
            if s[i] == '0':
                return 0
            dp[i] = dp[i-1]
        else:
            if s[i] == '0':
                dp[i] = dp[i-2]
            elif s[i-1] == '0':
                dp[i] = dp[i-1]
            else:
                dp[i] = dp[i-1] + dp[i-2]
        dp[i] %= 1000000
    return dp[n-1]
print(solve())
