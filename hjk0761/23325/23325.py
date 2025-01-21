import sys
sys.setrecursionlimit(10**6)

s = input()
n = len(s)

dp = [-1 * 10**9 for _ in range(n)]

dp[0] = 10 if s[0] == '+' else 1
if n > 1 and s[0] == '+' and s[1] == '-':
    dp[1] = 11

def find(index):
    if dp[index] != -1 * 10**9:
        return dp[index]
    if index >= 3 and s[index-1] == '+' and s[index] == '-' and find(index-3) != -1 * 10**9:
        dp[index] = max(dp[index], find(index-3) + (11 if s[index-2] == '+' else -11))
    if index >= 2 and find(index-2) != -1 * 10**9:
        dp[index] = max(dp[index],
                    (find(index-2) + (1 if s[index-1] == '+' else -1)) if s[index] == '-' else (find(index-2) + (10 if s[index-1] == '+' else -10)))
    return dp[index]

if n == 1:
    result = 10 if s[0] == '+' else 1
elif n == 2:
    result = 11
else:
    result = find(n-1)

print(result)
