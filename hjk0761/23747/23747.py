import sys
from collections import deque
def input(): return sys.stdin.readline().strip()

r, c = map(int, input().split())
grid = [list(input()) for _ in range(r)]

hr, hc = map(int, input().split())
hr, hc = hr-1, hc-1
history = list(input())

vision = [['#' for _ in range(c)] for _ in range(r)]

dy = [1, 0, -1, 0]
dx = [0, 1, 0, -1]

def warding(sy, sx):
    if vision[sy][sx] == '.':
        return
    base = grid[sy][sx]
    q = deque()
    q.append((sy, sx))
    while q:
        y, x = q.popleft()
        if vision[y][x] == '.':
            continue
        vision[y][x] = '.'
        for i in range(4):
            ny, nx = y + dy[i], x + dx[i]
            if ny < 0 or nx < 0 or ny >= r or nx >= c:
                continue
            if vision[ny][nx] == '.':
                continue
            if grid[ny][nx] != base:
                continue
            q.append((ny, nx))

for move in history:
    if move == 'W':
        warding(hr, hc)
    elif move == 'U':
        hr -= 1
    elif move == 'D':
        hr += 1
    elif move == 'L':
        hc -= 1
    elif move == 'R':
        hc += 1
    else:
        break

vision[hr][hc] = '.'
for i in range(4):
    y, x = hr+dy[i], hc+dx[i]
    if y < 0 or x < 0 or y >= r or x >= c:
        continue
    vision[y][x] = '.'

for i in range(r):
    print(''.join(vision[i]))
