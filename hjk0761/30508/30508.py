import sys
from collections import deque

n, m = map(int, input().split())
h, w = map(int, input().split())
crosswalk = [list(map(int, sys.stdin.readline().strip().split())) for _ in range(n)]

k = int(input())
sewer = [list(map(int, sys.stdin.readline().strip().split())) for _ in range(k)]

flooding = [[0 for _ in range(m)] for _ in range(n)]

dy = [1, 0, -1, 0]
dx = [0, 1, 0, -1]

def bfs(sy, sx):
    q = deque()
    q.append((sy, sx))
    flooding[sy][sx] = 1
    while q:
        y, x = q.popleft()
        for i in range(4):
            ny, nx = y + dy[i], x + dx[i]
            if ny < 0 or nx < 0 or ny >= n or nx >= m:
                continue
            if crosswalk[ny][nx] < crosswalk[y][x]:
                continue
            if flooding[ny][nx]:
                continue
            flooding[ny][nx] = 1
            q.append((ny, nx))

for r, c in sewer:
    bfs(r-1, c-1)

prefixSum = [[0 for _ in range(m+1)] for _ in range(n+1)]

prefixSum[1][1] = flooding[0][0]

for i in range(n):
    for j in range(m):
        if i == 0 and j == 0:
            continue
        prefixSum[i+1][j+1] = prefixSum[i][j+1] + prefixSum[i+1][j] - prefixSum[i][j] + flooding[i][j]

result = 0

for i in range(n-h+1):
    for j in range(m-w+1):
        if prefixSum[i+h][j+w] - prefixSum[i+h][j] - prefixSum[i][j+w] + prefixSum[i][j] == h*w:
            result += 1

print(result)
