import sys
def input(): return sys.stdin.readline().strip()

n, k = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(n)]
position = [[[] for _ in range(n)] for _ in range(n)]
piece = {}
for i in range(k):
    y, x, d = map(int, input().split())
    piece[i] = (y-1, x-1, d-1)
    position[y-1][x-1].append(i)
dy, dx = [0, 0, -1, 1], [1, -1, 0, 0]

def do(num, y, x, ny, nx, isRed):
    idx = position[y][x].index(num)
    temp = position[y][x][idx:]
    position[y][x] = position[y][x][:idx]
    if isRed:
        temp.reverse()
    position[ny][nx].extend(temp)
    for p in temp:
        piece[p] = (ny, nx, piece[p][2])

def reverse(idx):
    if idx == 0:
        return 1
    elif idx == 1:
        return 0
    elif idx == 2:
        return 3
    else:
        return 2

def blue(num, second):
    p = piece[num]
    if second:
        return p[0], p[1]
    piece[num] = (p[0], p[1], reverse(p[2]))
    ny, nx = p[0] + dy[piece[num][2]], p[1] + dx[piece[num][2]]
    isRed = False
    if ny < 0  or nx < 0 or ny >= n or nx >= n or board[ny][nx] == 2:
        return blue(num, True)
    elif board[ny][nx] == 1:
        isRed = True
    do(num, p[0], p[1], ny, nx, isRed)
    return ny, nx

def move(num):
    p = piece[num]
    y, x = p[0], p[1]
    ny, nx = y + dy[p[2]], x + dx[p[2]]
    isRed = False
    if ny < 0  or nx < 0 or ny >= n or nx >= n or board[ny][nx] == 2:
        return blue(num, False)
    elif board[ny][nx] == 1:
        isRed = True
    do(num, y, x, ny, nx, isRed)
    return ny, nx

def solve():
    turn = 1
    sign = False
    while True:
        if turn > 1000:
            break
        for i in range(k):
            y, x = move(i)
            if len(position[y][x]) >= 4:
                sign = True
                break
        if sign:
            break
        turn += 1
    return -1 if turn > 1000 else turn

print(solve())
