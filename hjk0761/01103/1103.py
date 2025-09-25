import sys
def input(): return sys.stdin.readline().strip()

n, m = map(int, input().split())
board = [list(input()) for _ in range(n)]
dy, dx = [0, -1, 0, 1], [-1, 0, 1, 0]

def find(dp):
    _max = -1
    for i in range(n):
        for j in range(m):
            _max = max(_max, dp[i][j])
    return _max

def solve():
    visited = [[False for _ in range(m)] for _ in range(n)]
    dp = [[0 for _ in range(m)] for _ in range(n)]
    def dfs(y, x, depth):
        if depth <= dp[y][x]:
            return True
        dp[y][x] = depth
        for i in range(4):
            ny, nx = y + int(board[y][x])*dy[i], x + int(board[y][x])*dx[i]
            if ny < 0 or nx < 0 or ny >= n or nx >= m:
                continue
            if visited[ny][nx]:
                return False
            if board[ny][nx] == 'H':
                continue
            visited[ny][nx] = True
            if not dfs(ny, nx, depth+1):
                return False
            visited[ny][nx] = False
        return True
    if dfs(0, 0, 1):
        return find(dp)
    return -1

print(solve())
