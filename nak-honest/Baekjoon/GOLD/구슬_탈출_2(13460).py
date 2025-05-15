import sys

answer = sys.maxsize
v = dict()

def dfs(cnt, r, b, d):
    if (r, b, d) in v and v[(r, b, d)] <= cnt:
        return
    v[(r, b, d)] = cnt
    cnt += 1
    is_red_hole = False
    is_red_end = False
    is_blue_end = False
    cur_r = (r[0], r[1])
    cur_b = (b[0], b[1])
    while not is_red_end or not is_blue_end:
        next_r = (cur_r[0] + d[0], cur_r[1] + d[1])
        next_b = (cur_b[0] + d[0], cur_b[1] + d[1])

        if not is_red_end:
            if board[next_r[0]][next_r[1]] == '.' and next_r != cur_b:
                cur_r = next_r
            elif next_r == cur_b and is_blue_end:
                is_red_end = True
            elif board[next_r[0]][next_r[1]] == 'O':
                is_red_hole = True
                is_red_end = True
                cur_r = (-1, -1)
            elif board[next_r[0]][next_r[1]] == '#':
                is_red_end = True
                if next_b == cur_r:
                    is_blue_end = True


        if not is_blue_end:
            if board[next_b[0]][next_b[1]] == '.' and next_b != cur_r:
                cur_b = next_b
            elif next_b == cur_r and is_red_end:
                is_blue_end = True
            elif board[next_b[0]][next_b[1]] == 'O':
                return
            elif board[next_b[0]][next_b[1]] == '#':
                is_blue_end = True
                if next_r == cur_b:
                    is_red_end = True

    if is_red_hole:
        global answer
        answer = min(answer, cnt)
        return

    if cnt == 10:
        return

    for next_d in udrl:
        dfs(cnt, cur_r, cur_b, next_d)

N, M = map(int, input().split())

board = [list(sys.stdin.readline().rstrip('\n')) for _ in range(N)]
red = (-1, -1)
blue = (-1, -1)


for i in range(N):
    for j in range(M):
        if board[i][j] == 'R':
            red = (i, j)
            board[i][j] = '.'
        elif board[i][j] == 'B':
            blue = (i, j)
            board[i][j] = '.'

udrl = [(0, 1), (0, -1), (1, 0), (-1, 0)]

for d in udrl:
    dfs(0, red, blue, d)

if answer == sys.maxsize:
    answer = -1

print(answer)


'''
재귀 함수로 이동 횟수, 빨간공 위치, 파란공 위치를 받아서
-> 4방향으로 기울이는 경우 각각에 대해 재귀 함수롤 또 호출한다.
-> 계산을 받았을 때 하자. -> udlr 이걸로 방향 받아서!
'''

