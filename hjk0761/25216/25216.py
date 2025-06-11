import sys, math
input = sys.stdin.readline

n, m, t = map(int, input().strip().split())
monster = [list(map(int, input().strip().split())) for _ in range(n)]
portal = dict()
for _ in range(m):
    u, v = map(int, input().strip().split())
    if u not in portal.keys():
        portal[u] = [v]
    else:
        portal[u].append(v)

dp = [[(0, 0) for _ in range(t+1)] for _ in range(n+1)]
dp[1][1] = (monster[0][3], math.ceil(monster[0][0]/monster[0][2]))

_maxCoin, _minDef = dp[1][1][0], dp[1][1][1]

for i in range(1, t):
    for j in range(1, n+1):
        if dp[j][i] != (0, 0):
            if j in portal.keys():
                for next in portal[j]:
                    a, x, y = monster[next-1][0], monster[next-1][1], monster[next-1][2]
                    coin = dp[j][i][0] + monster[next-1][3]
                    defence = max(dp[j][i][1], math.ceil((a + x*i)/y))
                    if dp[next][i+1] == (0, 0) or dp[next][i+1][0] < coin:
                        dp[next][i+1] = (coin, defence)
                    elif dp[next][i+1][0] == coin:
                        dp[next][i+1] = (dp[next][i+1][0], min(defence, dp[next][i+1][1]))
                    if dp[next][i+1][0] > _maxCoin:
                        _maxCoin = dp[next][i+1][0]
                        _minDef = dp[next][i+1][1]
                    elif dp[next][i+1][0] == _maxCoin:
                        _minDef = min(_minDef, dp[next][i+1][1])
print(_minDef)
