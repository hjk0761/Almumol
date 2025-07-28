import sys
def input(): return sys.stdin.readline().strip()

n = int(input())
a = list(map(int, input().split()))
b = list(map(int, input().split()))
aa = list(filter(lambda x: x != 0, a))
bb = list(filter(lambda x: x != 0, b))

a0, b0 = len(a)-len(aa), len(b)-len(bb)

def solve():
    if n == a0 or n == b0:
        return 0
    dp = [[[-sys.maxsize for _ in range(b0+1)] for _ in range(a0+1)] for _ in range(n+1)]
    for i in range(1, n+1):
        if i == 1:
            dp[i][0][0] = aa[0]*bb[0]
            if a0 > 0:
                dp[i][1][0] = 0
            if b0 > 0:
                dp[i][0][1] = 0
            continue
        for j in range(min(i, a0)+1):
            for k in range(min(i, b0)+1):
                if j == 0 and k != 0:
                    dp[i][j][k] = dp[i-1][j][k-1]
                elif k == 0 and j != 0:
                    dp[i][j][k] = dp[i-1][j-1][k]
                elif j != 0 and k != 0:
                    dp[i][j][k] = max(dp[i-1][j-1][k], dp[i-1][j][k-1], dp[i-1][j-1][k-1])
                if i-j <= len(aa) and i-k <= len(bb):
                    dp[i][j][k] = max(dp[i][j][k], dp[i-1][j][k] + aa[i-j-1]*bb[i-k-1])
    return dp[n][a0][b0]

print(solve())
