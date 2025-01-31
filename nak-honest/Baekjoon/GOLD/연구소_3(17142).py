import sys
from itertools import combinations
from copy import deepcopy

N, M = map(int, input().split())

maps = [list(map(int, sys.stdin.readline().split())) for _ in range(N)]

remain = set()
virus = []

udrl = [(1, 0), (-1, 0), (0, 1), (0, -1)]

for i in range(N):
    for j in range(N):
        if maps[i][j] == 2:
            maps[i][j] = '*'
            virus.append((i, j))
        elif maps[i][j] == 1:
            maps[i][j] = '-'
        else:
            remain.add((i, j))

answer = sys.maxsize

for active in list(combinations(virus, M)):
    remain_cp = remain.copy()
    maps_cp = deepcopy(maps)
    will_visit = [[]]
    cur_cnt = 0
    max_cnt = 0
    visited = [[False] * N for _ in range(N)]
    for i, j in active:
        visited[i][j] = True
        will_visit[0].append((i, j))

    while will_visit[cur_cnt]:
        index = will_visit[cur_cnt].pop()
        i, j = index

        if len(will_visit) == cur_cnt + 1:
            will_visit.append([])

        if cur_cnt >= answer or not remain_cp:
            break

        for diff_i, diff_j in udrl:
            next_i = i + diff_i
            next_j = j + diff_j

            if 0 <= next_i < N and 0 <= next_j < N and maps[next_i][next_j] != '-' and not visited[next_i][next_j]:
                visited[next_i][next_j] = True
                will_visit[cur_cnt + 1].append((next_i, next_j))
                if maps[next_i][next_j] != '*':
                    max_cnt = max(max_cnt, cur_cnt + 1)
                    remain_cp.remove((next_i, next_j))
        if not will_visit[cur_cnt]:
            cur_cnt += 1

    if not remain_cp:
        answer = min(answer, max_cnt)

if answer == sys.maxsize:
    answer = -1
print(answer)
