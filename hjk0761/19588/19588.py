import sys
def input(): return sys.stdin.readline().strip()

n, m = map(int, input().split())
members = [list(map(int, input().split())) for _ in range(n)]
members.sort(key = lambda x: x[0])
dp = [0 for _ in range(n+1)]
for i in range(n):
    dp[i+1] = dp[i] ^ members[i][1]

dp2 = [[0 for _ in range(n//m+1)] for _ in range(m)]
for i in range(m):
    for j in range(n//m):
        dp2[i][j+1] = (dp[(n-i)-j*m] ^ dp[(n-i)-(j+1)*m]) + dp2[i][j]

def solve(a, b):
    return dp2[b%m][a+b//m] - dp2[b%m][b//m]

result = []
q = int(input())
for _ in range(q):
    a, b = map(int, input().split())
    result.append(solve(a, b))

for re in result:
    print(re)
