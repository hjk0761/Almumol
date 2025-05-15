import sys
input = sys.stdin.readline

def parser(name):
    s = {"C":0, "D":2, "E":4, "F":5, "G":7, "A":9, "B":11}
    def base(n):
        scale, height = n[0], n[1]
        return 12*int(height) + s[scale]
    if len(name) == 2:
        return base(name)
    else:
        return base(name[:2]) + 1

MAX = 200_000
MAX_SCALE = 121
initial = list(input().strip().split())
n = int(input().strip())
sheet = list(input().strip().split())

def solve():
    dp = [[[(MAX, (-1, -1)) for _ in range(MAX_SCALE)] for _ in range(MAX_SCALE)] for _ in range(n+1)]
    l, r = parser(initial[0]), parser(initial[1])
    dp[0][l][r] = (0, (-1, -1))

    for i in range(n):
        next = parser(sheet[i])
        for j in range(MAX_SCALE):
            for k in range(MAX_SCALE):
                if dp[i][j][k][0] < MAX:
                    left = dp[i][j][k][0] + abs(j - next)
                    if dp[i+1][next][k][0] > left:
                        dp[i+1][next][k] = (left, (j, k))
                    right = dp[i][j][k][0] + abs(k - next)
                    if dp[i+1][j][next][0] > right:
                        dp[i+1][j][next] = (right, (j, k))

    result = MAX
    prev = (-1, -1)
    for i in range(MAX_SCALE):
        for j in range(MAX_SCALE):
            if dp[n][i][j][0] < result:
                result = dp[n][i][j][0]
                prev = (i, j)
    print(result)
    answer = []
    for i in range(n, 0, -1):
        if prev[0] == parser(sheet[i-1]):
            answer.append(1)
        else:
            answer.append(2)
        prev = dp[i][prev[0]][prev[1]][1]

    answer.reverse()
    print(*answer)
solve()