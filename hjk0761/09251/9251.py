a = input()
b = input()

if len(a) > len(b):
    b += 'a'*(len(a)-len(b))
else:
    a += 'a'*(len(b)-len(a))

n = len(a)

dp = [[0 for _ in range(n+1)] for _ in range(n+1)]

for i in range(1, n+1):
    for j in range(1, n+1):
        if a[i-1] == b[j-1]:
            dp[i][j] = dp[i-1][j-1] + 1
        else:
            dp[i][j] = max(dp[i-1][j], dp[i][j-1])

print(max(dp[-1]))
