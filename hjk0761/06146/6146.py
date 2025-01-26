import sys
from collections import deque

x, y, n = map(int, input().split())

board = [[' ' for _ in range(1001)] for _ in range(1001)]
board[x+500][y+500] = 'b'
dist = [[-1 for _ in range(1001)] for _ in range(1001)]

for _ in range(n):
    a, b = map(int, sys.stdin.readline().strip().split())
    board[a+500][b+500] = 'm'

q = deque()
q.append([500, 500])
dist[500][500] = 0

dx = [1, 0, -1, 0]
dy = [0, 1, 0, -1]

while q:
    cx, cy = q.popleft()
    if board[cx][cy] == 'b':
        break
    for i in range(4):
        nx, ny = cx + dx[i], cy + dy[i]
        if nx < 0 or ny < 0 or nx >= 1001 or ny >= 1001:
            continue
        if board[nx][ny] == 'm':
            continue
        if dist[nx][ny] > 0:
            continue
        dist[nx][ny] = dist[cx][cy] + 1
        q.append([nx, ny])

print(dist[x+500][y+500])
