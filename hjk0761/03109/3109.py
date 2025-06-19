import sys
def input(): return sys.stdin.readline().strip()

r, c = map(int, input().split())
ground = [list(input()) for _ in range(r)]

visited = [[False for _ in range(c)] for _ in range(r)]
dy = [1, 0, -1]
result = 0

q = []
for i in range(r):
    q.append((i, 0))
    while q:
        y, x = q.pop()
        if x == c-1:
            result += 1
            q = []
            break
        if visited[y][x]:
            continue
        visited[y][x] = True
        for j in range(3):
            ny = y + dy[j]
            nx = x + 1
            if ny < 0 or nx < 0  or ny >= r or nx >= c:
                continue
            if visited[ny][nx]:
                continue
            if ground[ny][nx] == 'x':
                continue
            q.append((ny, nx))
print(result)
