import sys

N, M = map(int, input().split())

maps = [list(sys.stdin.readline().rstrip('\n')) for _ in range(N)]

dist = {'L': (0, -1), 'R': (0, 1), 'U': (-1, 0), 'D': (1, 0)}

v = [[False] * M for _ in range(N)]
answer = 0

for i in range(N):
    for j in range(M):
        if v[i][j]:
            continue

        is_already = False
        cur_set = set()
        cur_i = i
        cur_j = j

        while (cur_i, cur_j) not in cur_set:
            if v[cur_i][cur_j]:
                is_already = True
                break
            cur_set.add((cur_i, cur_j))
            v[cur_i][cur_j] = True

            diff_i, diff_j = dist[maps[cur_i][cur_j]]
            cur_i += diff_i
            cur_j += diff_j

        if not is_already:
            answer += 1

print(answer)




