import sys
from collections import deque

M, N = map(int, input().split())
maps = [list(map(int, list(sys.stdin.readline().rstrip('\n')))) for _ in range(N)]

udrl = [(1, 0), (-1, 0), (0, 1), (0, -1)]

for i in range(N):
    for j in range(M):
        if maps[i][j] == 1:
            maps[i][j] = -1

visited = [[False] * M for _ in range(N)]

visited[0][0] = True

q = deque()
q.append((0, 0))
next_set = set()
next_set.add((0, 0))

answer = []

if N == 1 and M == 1:
    answer.append(0)

while q:
    i, j = q.popleft()

    for diff_i, diff_j in udrl:
        next_i = i + diff_i
        next_j = j + diff_j

        if next_i < 0 or next_i >= N or next_j < 0 or next_j >= M:
            continue

        if maps[next_i][next_j] == 0 and not visited[next_i][next_j]:
            visited[next_i][next_j] = True
            q.append((next_i, next_j))
            next_set.add((next_i, next_j))

            if next_i == N - 1 and next_j == M - 1:
                answer.append(0)

cur = 1


while not answer:
    cpy = next_set.copy()
    next_set.clear()

    for i, j in cpy:
        for diff_i, diff_j in udrl:
            next_i = i + diff_i
            next_j = j + diff_j

            if next_i < 0 or next_i >= N or next_j < 0 or next_j >= M:
                continue
            if visited[next_i][next_j]:
                continue

            if next_i == N - 1 and next_j == M - 1:
                answer.append(cur)
                break

            if maps[next_i][next_j] == -1:
                maps[next_i][next_j] = cur
                next_set.add((next_i, next_j))
                q.append((next_i, next_j))
                visited[next_i][next_j] = True

        if answer:
            break

    while q and not answer:
        i, j = q.popleft()

        for diff_i, diff_j in udrl:
            next_i = i + diff_i
            next_j = j + diff_j

            if next_i < 0 or next_i >= N or next_j < 0 or next_j >= M:
                continue

            if maps[next_i][next_j] == 0 and not visited[next_i][next_j]:
                visited[next_i][next_j] = True
                q.append((next_i, next_j))
                next_set.add((next_i, next_j))

                if next_i == N - 1 and next_j == M - 1:
                    answer.append(cur)

    cur += 1

print(answer[0])

