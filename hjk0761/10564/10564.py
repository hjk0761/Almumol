import sys
input = sys.stdin.readline

def check(n, x, y, dp, score):
    if x > n or dp[x][y]:
        return
    dp[x][y] = True
    for s in score:
        check(n, x+y+s, y+s, dp, score)

def solve():
    n, m = map(int, input().strip().split())
    score = list(map(int, input().strip().split()))
    dp = [[False for _ in range(501)] for _ in range(n+1)]
    check(n, 0, 0, dp, score)
    for i in range(500, 0, -1):
        if dp[n][i]:
            return i
    return -1

t = int(input())
result = []
for _ in range(t):
    result.append(solve())

for re in result:
    print(re)
