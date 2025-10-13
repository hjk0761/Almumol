import sys
from collections import deque
def input(): return sys.stdin.readline().strip()

n, m = map(int, input().split())
sy, sx = map(int, input().split())
ey, ex = map(int, input().split())
sy, sx, ey, ex = sy-1, sx-1, ey-1, ex-1
maze = [list(map(int, input().split())) for _ in range(n)]
dy, dx = [1, 0, -1, 0], [0, 1, 0, -1]
visited = [[[False, False] for _ in range(m)] for _ in range(n)]
distance = [[[sys.maxsize, sys.maxsize] for _ in range(m)] for _ in range(n)]

def bfs(sy, sx, ey, ex):
    q = deque()
    q.append((sy, sx, 0))
    visited[sy][sx][0] = True
    distance[sy][sx][0] = 0
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
    result = min(distance[ey][ex])
    return result if result < sys.maxsize else -1

print(bfs(sy, sx, ey, ex))
