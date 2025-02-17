import sys
from collections import deque

n, m = map(int, input().split())

maze = [list(map(int, sys.stdin.readline().strip())) for _ in range(n)]
distance = [[[sys.maxsize, sys.maxsize] for _ in range(m)] for _ in range(n)]
visited = [[[False, False] for _ in range(m)] for _ in range(n)]

dy = [1, 0, -1, 0]
dx = [0, 1, 0, -1]

def bfs(sy, sx, sz):
    q = deque()
    q.append((sy, sx, sz))
    visited[sy][sx][0] = True
    distance[sy][sx][0] = 1
    while q:
        y, x, z = q.popleft()
        for i in range(4):
            ny, nx = y + dy[i], x + dx[i]
            if ny < 0 or nx < 0 or ny >= n or nx >= m:
                continue
            if z == 1 and maze[ny][nx] == 1:
                continue
            nz = 1 if maze[ny][nx] == 1 else z
            if visited[ny][nx][nz]:
                continue
            visited[ny][nx][nz] = True
            distance[ny][nx][nz] = distance[y][x][z] + 1
            q.append((ny, nx, nz))

bfs(0, 0, 0)
print(min(distance[n-1][m-1]) if min(distance[n-1][m-1]) < sys.maxsize else -1)
