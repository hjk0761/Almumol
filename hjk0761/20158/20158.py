import sys
from collections import deque
def input(): return sys.stdin.readline().strip()

n = int(input())
site = [list(map(int, input().split())) for _ in range(n)]

dy, dx = [1, 0, -1, 0], [0, 1, 0, -1]

visited = [[[[False for _ in range(16)] for _ in range(4)] for _ in range(n)] for _ in range(n)]
time = [[[[sys.maxsize for _ in range(16)] for _ in range(4)] for _ in range(n)] for _ in range(n)]

def bfs():
    q = deque()
    q.append((0, 0, 0, 0))
    q.append((0, 0, 1, 0))
    while q:
        y, x, d, acc = q.popleft()
        if visited[y][x][d][acc]:
            continue
        visited[y][x][d][acc] = True
        if y == 0 and x == 0:
            cur_time = 0
        else:
            cur_time = time[y][x][d][acc]
        for i in range(4):
            if i == d:
                ny, nx = y + dy[i]*(acc+1), x + dx[i]*(acc+1)
            else:
                ny, nx = y + dy[i], x + dx[i]
            if ny < 0 or nx < 0 or ny >= n or nx >= n:
                continue
            nacc = 1 if i != d else (acc+1)
            if visited[ny][nx][i][nacc]:
                continue
            possible = True
            temp = acc+1 if i == d else 1
            for t in range(1, temp):
                ty, tx = y + dy[i]*t, x + dx[i]*t
                if site[ty][tx] == 0:
                    continue
                if site[ty][tx] <= cur_time:
                    possible = False
                    break
            if (site[ny][nx] != 0) and (site[ny][nx] <= cur_time+1):
                possible = False
            if not possible:
                continue
            time[ny][nx][i][nacc] = min(time[ny][nx][i][nacc], cur_time + 1)
            q.append((ny, nx, i, nacc))
    return

bfs()
result = sys.maxsize
for i in range(4):
    for j in range(16):
        if time[n-1][n-1][i][j] != -1:
            result = min(result, time[n-1][n-1][i][j])
if n == 1:
    result = 0
if result == sys.maxsize:
    print("Fired")
else:
    print(result)
