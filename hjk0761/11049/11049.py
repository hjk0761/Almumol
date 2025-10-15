import sys
def input(): return sys.stdin.readline().strip()

n = int(input())
matrix = [list(map(int, input().split())) for _ in range(n)]

dp = [[sys.maxsize for _ in range(n)] for _ in range(n)]

for i in range(n):
    for j in range(n-i):
        _from, _to = j, j+i
        if _from == _to:
            dp[_from][_to] = 0
            continue
        elif _from == _to - 1:
            dp[_from][_to] = matrix[_from][0] * matrix[_from][1] * matrix[_to][1]
        for k in range(_from, _to):
            dp[_from][_to] = min(dp[_from][_to], dp[_from][k] + dp[k+1][_to] + matrix[_from][0]*matrix[k][1]*matrix[_to][1])

print(dp[0][n-1])
