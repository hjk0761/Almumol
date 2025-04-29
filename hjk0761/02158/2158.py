import sys, heapq
input = sys.stdin.readline

v, r, c = map(int, input().strip().split())
mountain = [list(map(int, input().strip().split())) for _ in range(r)]
dy = [1, 0, -1, 0]
dx = [0, 1, 0, -1]

def dijk(sy, sx):
    q = []
    time = [[sys.maxsize for _ in range(c)] for _ in range(r)]
    time[sy][sx] = 0.0
    visited = [[False for _ in range(c)] for _ in range(r)]
    heapq.heappush(q, (0, sy, sx, v))
    while q:
        cur_time, y, x, cur_speed = heapq.heappop(q)
        visited[y][x] = True
        for i in range(4):
            ny, nx = y + dy[i], x + dx[i]
            if ny < 0 or nx < 0 or ny >= r or nx >= c:
                continue
            if visited[ny][nx]:
                continue
            new_time = time[y][x] + 1/cur_speed
            if time[ny][nx] > new_time:
                time[ny][nx] = new_time
                new_speed = cur_speed * (2 ** (mountain[y][x] - mountain[ny][nx]))
                heapq.heappush(q, (new_time, ny, nx, new_speed))
    return time

result = dijk(0, 0)
print("%0.2f"%result[r-1][c-1])
