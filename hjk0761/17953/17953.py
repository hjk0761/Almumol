import sys
input = sys.stdin.readline

n, m = map(int, input().strip().split())
dessert = [list(map(int, input().strip().split())) for _ in range(m)]

dp = [[0 for _ in range(m)] for _ in range(n+1)]

def find(l, index):
    _max = -1
    for i in range(len(l)):
        if i != index:
            _max = max(_max, l[i])
    return _max

for i in range(m):
    dp[1][i] = dessert[i][0]

for i in range(1, n):
    for j in range(m):
        dp[i+1][j] = max(find(dp[i], j) + dessert[j][i], dp[i][j] + dessert[j][i]//2)

print(max(dp[-1]))
