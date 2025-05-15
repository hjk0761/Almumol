import sys
from collections import deque

n, m = map(int, input().split())
lab = [list(map(int, sys.stdin.readline().strip().split())) for _ in range(n)]

dy = [1, 0, -1, 0]
dx = [0, 1, 0, -1]

def bfs(s, board):
    q = deque()
    for sy, sx in s:
        q.append((sy, sx))
    while q:
        y, x = q.popleft()
        for i in range(4):
            ny, nx = y + dy[i], x + dx[i]
            if ny < 0 or nx < 0 or ny >= n or nx >= m:
                continue
            if board[ny][nx] != 0:
                continue
            board[ny][nx] = 2
            q.append((ny, nx))
    count = 0
    for i in range(n):
        for j in range(m):
            if board[i][j] == 0:
                count += 1
    return count

virus = []
empty = []
for i in range(n):
    for j in range(m):
        if lab[i][j] == 2:
            virus.append((i, j))
        elif lab[i][j] == 0:
            empty.append((i, j))

result = -1
for i in range(len(empty)-2):
    for j in range(i+1, len(empty)-1):
        for k in range(j+1, len(empty)):
            copy = [a[:] for a in lab]
            copy[empty[i][0]][empty[i][1]] = 1
            copy[empty[j][0]][empty[j][1]] = 1
            copy[empty[k][0]][empty[k][1]] = 1
            result = max(result, bfs(virus, copy))

print(result)
