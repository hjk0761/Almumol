import sys

r, c = map(int, input().split())

pipes = [list(sys.stdin.readline().strip()) for _ in range(r)]

dy = [1, 0, -1, 0]
dx = [0, 1, 0, -1]

result = []
possible = [['|', '+', '2', '3'], ['-', '+', '3', '4'], ['|', '+', '1', '4'], ['-', '+', '1', '2']]

def solve():
    for i in range(r):
        for j in range(c):
            if pipes[i][j] != '.':
                continue
            near = 0
            for k in range(4):
                ny, nx = i + dy[k], j + dx[k]
                if ny < 0 or nx < 0 or ny >= r or nx >= c:
                    continue
                if pipes[ny][nx] == '.':
                    continue
                if pipes[ny][nx] in possible[k]:
                    near += 2 ** k
            if near == 0:
                continue
            result.append(i+1)
            result.append(j+1)
            return near
        
shape = solve()

if shape == 3:
    result.append("1")
elif shape == 5:
    result.append("|")
elif shape == 9:
    result.append("4")
elif shape == 6:
    result.append("2")
elif shape == 10:
    result.append("-")
elif shape == 12:
    result.append("3")
elif shape == 15:
    result.append("+")

print(*result)
