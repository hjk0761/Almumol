import sys
from collections import deque

n = int(input())

sea = [list(map(int, sys.stdin.readline().strip().split())) for _ in range(n)]

size = 2
time = 0
count = 0

def find_baby_shark():
    for i in range(n):
        for j in range(n):
            if sea[i][j] == 9:
                return i, j

dy = [-1, 0, 1, 0]
dx = [0, -1, 0, 1]

def find_closest_fish(sy, sx):
    global size, time, count
    q = deque()
    q.append((sy, sx, 0))
    visited = set()
    fishes = []
    _min = sys.maxsize
    visited.add((sy, sx))
    while q:
        y, x, length = q.popleft()
        if sea[y][x] != 0 and sea[y][x] != 9 and sea[y][x] < size:
            if length < _min:
                fishes = [(y, x, length)]
                _min = length
            elif length == _min:
                fishes.append((y, x, length))
        if length >= _min:
            continue
        for i in range(4):
            ny, nx = y + dy[i], x + dx[i]
            if ny < 0 or nx < 0 or ny >= n or nx >= n:
                continue
            if (ny, nx) in visited:
                continue
            if sea[ny][nx] > size:
                continue
            visited.add((ny, nx))
            q.append((ny, nx, length+1))
    fishes.sort(key = lambda x: (x[0], x[1]))
    return fishes[0] if fishes else (-1, -1, -1)

def eat(sy, sx, y, x, length):
    global size, count, time
    sea[sy][sx] = 0
    sea[y][x] = 9
    count += 1
    time += length
    if count == size:
        size += 1
        count = 0

def solve():
    sy, sx = find_baby_shark()
    y, x, length = find_closest_fish(sy, sx)
    while (y, x, length) != (-1, -1, -1):
        eat(sy, sx, y, x, length)
        sy, sx = y, x
        y, x, length = find_closest_fish(sy, sx)

solve()
print(time)