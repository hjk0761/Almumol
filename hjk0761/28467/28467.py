import sys
def input(): return sys.stdin.readline().strip()

n = int(input())
card = list(map(int, input().split()))

_max = [[0 for _ in range(n)] for _ in range(n)]
for i in range(n):
    _max[i][i] = card[i]
for i in range(n):
    for j in range(i+1, n):
        _max[i][j] = max(_max[i][j-1], card[j])

dp = [[sys.maxsize for _ in range(n)] for _ in range(n)]

def find(_from, _to):
    if _from == _to:
        return 0
    if dp[_from][_to] != sys.maxsize:
        return dp[_from][_to]
    for i in range(_from, _to):
        dp[_from][_to] = min(dp[_from][_to], find(_from, i) + find(i+1, _to) + _max[_from][i] + _max[i+1][_to])
    return dp[_from][_to]

print(find(0, n-1))
