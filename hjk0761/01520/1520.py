import sys
sys.setrecursionlimit(10 ** 6)

n, m = map(int, input().split())
board = [[0 for _ in range(m)] for _ in range(n)]
dp = [[-1 for _ in range(m)] for _ in range(n)]

for i in range(n):
    board[i] = list(map(int, sys.stdin.readline().strip().split()))

dy = [1, 0, -1, 0]
dx = [0, 1, 0, -1]

def dfs(y, x):
    if y == n-1 and x == m-1:
        return 1
    if dp[y][x] != -1:
        return dp[y][x]
    dp[y][x] = 0
    for i in range(4):
        ny, nx = y + dy[i], x + dx[i]
        if ny < 0 or nx < 0 or ny >= n or nx >= m:
            continue
        if board[ny][nx] >= board[y][x]:
            continue
        dp[y][x] += dfs(ny, nx)
    return dp[y][x]

print(dfs(0, 0))
