import sys
from collections import deque
input = sys.stdin.readline

n, l, r = map(int, input().strip().split())
population = [list(map(int, input().strip().split())) for _ in range(n)]

dy = [1, 0, -1, 0]
dx = [0, 1, 0, -1]

def bfs(board, visited, sy, sx):
    q = deque()
    q.append((sy, sx))
    union = [(sy, sx)]
    visited[sy][sx] = True
    while q:
        y, x = q.popleft()
        for i in range(4):
            ny, nx = y + dy[i], x + dx[i]
            if ny < 0 or nx < 0 or ny >= n or nx >= n:
                continue
            if visited[ny][nx]:
                continue
            if (abs(board[ny][nx] - board[y][x]) < l) or (abs(board[ny][nx] - board[y][x]) > r):
                continue
            visited[ny][nx] = True
            union.append((ny, nx))
            q.append((ny, nx))
    changed = False
    total = 0
    for y, x in union:
        total += board[y][x]
    after = total // len(union)
    for y, x in union:
        if board[y][x] != after:
            board[y][x] = after
            changed = True
    return changed

def day(board):
    visited = [[False for _ in range(n)] for _ in range(n)]
    changed = False
    for i in range(n):
        for j in range(n):
            if visited[i][j]:
                continue
            temp = bfs(board, visited, i, j)
            changed = changed or temp
    return changed
result = 0
while True:
    happened = day(population)
    if not happened:
        break
    result += 1
print(result)
