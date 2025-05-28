import sys
def input(): return sys.stdin.readline().strip()

n, m = map(int, input().split())
island = [list(input()) for _ in range(n)]

sy, sx = -1, -1
gate = []

for i in range(n):
    for j in range(m):
        if island[i][j] == 'R':
            sy, sx = i, j
        elif island[i][j] == 'O':
            gate.append((i, j))

dp = [[-1 for _ in range(m)] for _ in range(n)]
dy = [1, 0, -1]
dp[sy][sx] = 0

def solve():
    if len(gate) == 0:
        return -1
    for j in range(sx+1, m):
        for i in range(n):
            if island[i][j] == '#':
                continue
            _max = -1
            for d in dy:
                py, px = i+d, j-1
                if py < 0 or px < 0 or py >= n:
                    continue
                _max = max(_max, dp[py][px])
            dp[i][j] = _max
            if dp[i][j] > -1 and island[i][j] == 'C':
                dp[i][j] += 1
    result = -1
    for y, x in gate:
        result = max(result, dp[y][x])
    return result

print(solve())
