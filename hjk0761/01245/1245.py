import sys
sys.setrecursionlimit(10**6)

n, m = map(int, input().split())

farm = [[-1 for _ in range(m)] for _ in range(n)]

for i in range(n):
    farm[i] = list(map(int, sys.stdin.readline().strip().split()))

dy, dx = [1, 1, 0, -1, -1, -1, 0, 1], [0, 1, 1, 1, 0, -1, -1, -1]

visited = [[False for _ in range(m)] for _ in range(n)]

count = 0

def search(y, x):
    global visited, isPeak
    for k in range(8):
        ny, nx = y + dy[k], x + dx[k]
        if ny < 0 or nx < 0 or ny >= n or nx >= m:
            continue
        if farm[ny][nx] > farm[y][x]:
            isPeak = False
        if visited[ny][nx]:
            continue
        if farm[ny][nx] != farm[y][x]:
            continue
        visited[ny][nx] = True
        search(ny, nx)

for i in range(n):
    for j in range(m):
        if visited[i][j]:
            continue
        isPeak = True
        search(i, j)
        if isPeak:
            count += 1

print(count)
