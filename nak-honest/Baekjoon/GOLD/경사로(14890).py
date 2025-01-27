import sys

def is_row_road(i):
    visited = [False] * N
    for j in range(N-1):
        if maps[i][j] == maps[i][j+1]:
            continue
        elif abs(maps[i][j] - maps[i][j+1]) != 1:
            return False
        elif maps[i][j] > maps[i][j+1]:
            for k in range(j+1, j+1+L):
                if k == N:
                    return False
                if maps[i][k] != maps[i][j+1]:
                    return False
                if visited[k]:
                    return False
                visited[k] = True
        elif maps[i][j] < maps[i][j+1]:
            for k in range(j, j-L, -1):
                if k == -1:
                    return False
                if maps[i][k] != maps[i][j]:
                    return False
                if visited[k]:
                    return False
                visited[k] = True

    return True

def is_col_road(j):
    visited = [False] * N
    for i in range(N-1):
        if maps[i][j] == maps[i+1][j]:
            continue
        elif abs(maps[i][j] - maps[i+1][j]) != 1:
            return False
        elif maps[i][j] > maps[i+1][j]:
            for k in range(i+1, i+1+L):
                if k == N:
                    return False
                if maps[k][j] != maps[i+1][j]:
                    return False
                if visited[k]:
                    return False
                visited[k] = True
        elif maps[i][j] < maps[i+1][j]:
            for k in range(i, i-L, -1):
                if k == -1:
                    return False
                if maps[k][j] != maps[i][j]:
                    return False
                if visited[k]:
                    return False
                visited[k] = True

    return True


N, L = map(int, sys.stdin.readline().split())
maps = [list(map(int, sys.stdin.readline().split())) for _ in range(N)]

answer = 0

for x in range(N):
    if is_row_road(x):
        answer += 1
    if is_col_road(x):
        answer += 1

print(answer)
