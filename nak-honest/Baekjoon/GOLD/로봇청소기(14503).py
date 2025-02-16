import sys

dirs = [(-1, 0), (0, 1), (1, 0), (0, -1)]
reverse_dirs = [(1, 0), (0, -1), (-1, 0), (0, 1)]
N, M = map(int, input().split())
r, c, d = map(int, input().split())

maps = [list(map(int, sys.stdin.readline().split())) for _ in range(N)]

answer = 0
while True:
    if maps[r][c] == 0:
        maps[r][c] = 2
        answer += 1

    is_back = True
    for i, j in dirs:
        if maps[r + i][c + j] == 0:
            is_back = False
            d = (d - 1) % 4

            if maps[r + dirs[d][0]][c + dirs[d][1]] == 0:
                r += dirs[d][0]
                c += dirs[d][1]

            break

    if is_back:
        if maps[r + reverse_dirs[d][0]][c + reverse_dirs[d][1]] == 1:
            break
        else:
            r += reverse_dirs[d][0]
            c += reverse_dirs[d][1]

print(answer)
