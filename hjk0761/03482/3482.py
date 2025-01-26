import sys

t = int(input())

dy = [1, 0, -1, 0]
dx = [0, 1, 0, -1]

def find_farthest_node(board: list, r: int, c: int, sy: int, sx: int):
    visited = [[False for _ in range(c)] for _ in range(r)]
    stack = []
    _max = -1
    my, mx = sy, sx
    stack.append([sy, sx, 0])
    while stack:
        y, x, d = stack.pop()
        if visited[y][x]:
            continue
        visited[y][x] = True
        if d > _max:
            _max = d
            my, mx = y, x
        for i in range(4):
            ny, nx = y + dy[i], x + dx[i]
            if ny < 0 or nx < 0 or ny >= r or nx >= c:
                continue
            if board[ny][nx] == '#':
                continue
            stack.append([ny, nx, d+1])
    return [my, mx]

def find_longest_distance(board: list, r: int, c: int, sy: int, sx: int):
    visited = [[False for _ in range(c)] for _ in range(r)]
    stack = []
    _max = -1
    stack.append([sy, sx, 0])
    while stack:
        y, x, d = stack.pop()
        if visited[y][x]:
            continue
        visited[y][x] = True
        _max = max(_max, d)
        for i in range(4):
            ny, nx = y + dy[i], x + dx[i]
            if ny < 0 or nx < 0 or ny >= r or nx >= c:
                continue
            if board[ny][nx] == '#':
                continue
            stack.append([ny, nx, d+1])
    return _max


for _ in range(t):
    c, r = map(int, sys.stdin.readline().strip().split())
    labyrinth = [['' for _ in range(c)] for _ in range(r)]
    for i in range(r):
        labyrinth[i] = list(sys.stdin.readline().strip())

    y, x = -1, -1

    for i in range(r):
        found = False
        for j in range(c):
            if labyrinth[i][j] == '.':
                y, x = find_farthest_node(labyrinth, r, c, i, j)
                found = True
                break
        if found:
            break
    
    result = find_longest_distance(labyrinth, r, c, y, x)
    print("Maximum rope length is " + str(result) + ".")
