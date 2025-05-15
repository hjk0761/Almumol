import sys
from copy import deepcopy
from collections import deque

def dfs(cnt, cur_board):
    if cnt == 5:
        global answer
        for i in range(N):
            answer = max(answer, max(cur_board[i]))

        return

    # 왼쪽
    next_board = []
    for i in range(N):
        cur_row = []
        for el in cur_board[i]:
            if el != 0:
                cur_row.append(el)

        add_row = []

        j = 0
        while j < len(cur_row):
            if j + 1 < len(cur_row) and cur_row[j] == cur_row[j + 1]:
                add_row.append(cur_row[j] << 1)
                j += 2
            else:
                add_row.append(cur_row[j])
                j += 1
        add_row = add_row + [0] * (N - len(add_row))
        next_board.append(add_row)

    dfs(cnt + 1, next_board)

    # 오른쪽
    next_board = []
    for i in range(N):
        cur_row = deque()
        for el in reversed(cur_board[i]):
            if el != 0:
                cur_row.appendleft(el)

        add_row = deque()

        j = len(cur_row) - 1
        while j >= 0:
            if j - 1 >= 0 and cur_row[j] == cur_row[j - 1]:
                add_row.appendleft(cur_row[j] << 1)
                j -= 2
            else:
                add_row.appendleft(cur_row[j])
                j -= 1
        add_row = [0] * (N - len(add_row)) + list(add_row)
        next_board.append(add_row)

    dfs(cnt + 1, next_board)

    # 위
    next_board = [[0] * N for _ in range(N)]
    cols = []
    for j in range(N):
        cur_col = []
        for i in range(N):
            if cur_board[i][j] != 0:
                cur_col.append(cur_board[i][j])

        add_col = []

        i = 0
        while i < len(cur_col):
            if i + 1 < len(cur_col) and cur_col[i] == cur_col[i + 1]:
                add_col.append(cur_col[i] << 1)
                i += 2
            else:
                add_col.append(cur_col[i])
                i += 1
        add_col = add_col + [0] * (N - len(add_col))
        cols.append(add_col)

    for j in range(N):
        for i in range(N):
            next_board[i][j] = cols[j][i]

    dfs(cnt + 1, next_board)

    # 아래
    next_board = [[0] * N for _ in range(N)]
    cols = []
    for j in range(N):
        cur_col = deque()
        for i in range(N-1, -1, -1):
            if cur_board[i][j] != 0:
                cur_col.appendleft(cur_board[i][j])

        add_col = deque()

        i = len(cur_col) - 1
        while i >= 0:
            if i - 1 >= 0 and cur_col[i] == cur_col[i - 1]:
                add_col.appendleft(cur_col[i] << 1)
                i -= 2
            else:
                add_col.appendleft(cur_col[i])
                i -= 1
        add_col = [0] * (N - len(add_col)) + list(add_col)
        cols.append(add_col)

    for j in range(N):
        for i in range(N):
            next_board[i][j] = cols[j][i]
    dfs(cnt + 1, next_board)




N = int(input())

board = [list(map(int, sys.stdin.readline().split())) for _ in range(N)]
udrl = [(0, 1), (0, -1), (1, 0), (-1, 0)]

answer = 0

dfs(0, board)
print(answer)
