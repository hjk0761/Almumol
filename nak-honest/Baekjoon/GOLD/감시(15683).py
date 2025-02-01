import sys

N, M = map(int, sys.stdin.readline().split())
maps = [list(map(int, sys.stdin.readline().split())) for _ in range(N)]

u = (-1, 0)
d = (1, 0)
r = (0, 1)
l = (0, -1)

cctv_directions = [
    [[u], [d], [l], [r]],
    [[u, d], [l, r]],
    [[u, r], [r, d], [d, l], [l, u]],
    [[u, r, d], [r, d, l], [d, l, u], [l, u, r]],
    [[u, d, r, l]]
]

total_space = N * M
cctv = []
for i in range(N):
    for j in range(M):
        if 1 <= maps[i][j] <= 5:
            cctv.append(((i, j), maps[i][j] - 1))
        if maps[i][j] != 0:
            total_space -= 1

def can_go(i, j):
    return 0 <= i < N and 0 <= j < M and maps[i][j] != 6

max_cnt = 0
def find(i, visited, cnt):
    if i == len(cctv) - 1:
        global max_cnt
        max_cnt = max(max_cnt, cnt)
        return
    next_type = cctv[i+1][1]

    for next_directions in cctv_directions[next_type]:
        next_cnt = cnt
        next_visited = visited
        for next_direction in next_directions:
            next_i = cctv[i + 1][0][0]
            next_j = cctv[i + 1][0][1]
            while can_go(next_i + next_direction[0], next_j + next_direction[1]):
                if maps[next_i + next_direction[0]][next_j + next_direction[1]] == 0 and (next_visited & (1 << ((next_i + next_direction[0]) * M + next_j + next_direction[1]))) == 0:
                    next_cnt += 1
                    next_visited = (next_visited | (1 << ((next_i + next_direction[0]) * M + next_j + next_direction[1])))

                next_i = next_i + next_direction[0]
                next_j = next_j + next_direction[1]

        find(i+1, next_visited, next_cnt)


find(-1, 0, 0)
print(total_space - max_cnt)
