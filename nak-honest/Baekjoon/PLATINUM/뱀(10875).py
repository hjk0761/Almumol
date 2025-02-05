import sys

# ((a, b), (c, d))
def find_cross(cur, past, _dir):
    min_cur_x = min(cur[0][0], cur[1][0])
    min_cur_y = min(cur[0][1], cur[1][1])
    max_cur_x = max(cur[0][0], cur[1][0])
    max_cur_y = max(cur[0][1], cur[1][1])

    min_past_x = min(past[0][0], past[1][0])
    min_past_y = min(past[0][1], past[1][1])
    max_past_x = max(past[0][0], past[1][0])
    max_past_y = max(past[0][1], past[1][1])

    # 가로 가로
    if cur[0][1] == cur[1][1] and past[0][1] == past[1][1]:
        # y 값이 다르므로 겹칠수가 없음
        if cur[0][1] != past[0][1]:
            return -1
        if not (min_cur_x <= min_past_x <= max_cur_x <= max_past_x or min_past_x <= min_cur_x <= max_past_x <= max_cur_x
                or min_cur_x <= min_past_x <= max_past_x <= max_cur_x or min_past_x <= min_cur_x <= max_cur_x <= max_past_x):
            return -1
        # 오른쪽
        if _dir == 0:
            if max_cur_x >= min_past_x:
                return min_past_x - min_cur_x + 1
        # 왼쪽 또는 길이 1
        else:
            if min_cur_x <= max_past_x:
                return max_cur_x - max_past_x + 1

    # 세로 세로
    elif cur[0][0] == cur[1][0] and past[0][0] == past[1][0]:
        # x 값이 다르므로 겹칠수가 없음
        if cur[0][0] != past[0][0]:
            return -1
        if not (min_cur_y <= min_past_y <= max_cur_y <= max_past_y or min_past_y <= min_cur_y <= max_past_y <= max_cur_y
                or min_cur_y <= min_past_y <= max_past_y <= max_cur_y or min_past_y <= min_cur_y <= max_cur_y <= max_past_y):
            return -1
        # 위
        if _dir == 1:
            if max_cur_y >= min_past_y:
                return min_past_y - min_cur_y + 1
        # 아래 또는 길이 1
        else:
            if min_cur_y <= max_past_y:
                return max_cur_y - max_past_y + 1

    # 가로 세로
    elif cur[0][1] == cur[1][1]:
        if not (min_cur_x <= min_past_x <= max_cur_x and min_past_y <= min_cur_y <= max_past_y):
            return -1
        if _dir == 0:
            return min_past_x - min_cur_x + 1
        elif _dir == 2:
            return max_cur_x - max_past_x + 1
    else:
        if not (min_past_x <= min_cur_x <= max_past_x and min_cur_y <= min_past_y <= max_cur_y):
            return -1
        if _dir == 1:
            return min_past_y - min_cur_y + 1
        elif _dir == 3:
            return max_cur_y - max_past_y + 1

    return -1

L = int(input())
N = int(input())

ruld = [(1, 0), (0, 1), (-1, 0), (0, -1)]
cur_dir = 0
cur_t = 0
position = [0, 0]

lines = []
lines.append(((0, 0), (0, 0)))

answer = 0
inps = [sys.stdin.readline().split() for _ in range(N)]
for inp in inps:
    t = int(inp[0])
    d = inp[1]

    cur_diff = ruld[cur_dir]

    next_line = ((position[0] + cur_diff[0], position[1] + cur_diff[1]), (position[0] + cur_diff[0] * t, position[1] + cur_diff[1] * t))

    last_t = sys.maxsize
    for line in lines:
        ret = find_cross(next_line, line, cur_dir)
        if ret == -1:
            continue
        last_t = min(ret, last_t)

    if last_t != sys.maxsize:
        answer = cur_t + last_t
        break

    if answer > 0:
        break

    if not (-L <= next_line[1][0] <= L and -L <= next_line[1][1] <= L):
        last_t = 0
        if cur_dir == 0:
            last_t = L - position[0] + 1
        elif cur_dir == 1:
            last_t = L - position[1] + 1
        elif cur_dir == 2:
            last_t = position[0] + L + 1
        else:
            last_t = position[1] + L + 1
        answer = cur_t + last_t

    if answer > 0:
        break

    cur_t += t
    lines.append(next_line)
    position[0] += cur_diff[0] * t
    position[1] += cur_diff[1] * t

    if d == 'L':
        cur_dir = (cur_dir + 1) % 4
    else:
        cur_dir = (cur_dir - 1) % 4

if answer == 0:
    if cur_dir == 0:
        next_line = ((position[0] + 1, position[1]), (L, position[1]))
    elif cur_dir == 1:
        next_line = ((position[0], position[1] + 1), (position[0], L))
    elif cur_dir == 2:
        next_line = ((position[0] - 1, position[1]), (-L, position[1]))
    else:
        next_line = ((position[0], position[1] - 1), (position[0], -L))

    last_t = sys.maxsize
    for line in lines:
        ret = find_cross(next_line, line, cur_dir)
        if ret == -1:
            continue
        last_t = min(ret, last_t)

    if last_t != sys.maxsize:
        answer = cur_t + last_t

if answer == 0:
    if cur_dir == 0:
        last_t = L - position[0] + 1
    elif cur_dir == 1:
        last_t = L - position[1] + 1
    elif cur_dir == 2:
        last_t = position[0] + L + 1
    else:
        last_t = position[1] + L + 1
    answer = cur_t + last_t

print(answer)

