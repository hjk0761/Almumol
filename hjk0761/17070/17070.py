import sys

n = int(input())

house = [list(map(int, sys.stdin.readline().strip().split())) for _ in range(n)]

ver = [[0 for _ in range(n)] for _ in range(n)]
hor = [[0 for _ in range(n)] for _ in range(n)]
diag = [[0 for _ in range(n)] for _ in range(n)]

ver[0][1] = 1

for i in range(n):
    for j in range(n):
        if i == 0 and (j == 0 or j == 1):
            continue
        if house[i][j] == 1:
            continue
        if j != 0:
            ver[i][j] = ver[i][j-1] + diag[i][j-1]
        if i != 0:
            hor[i][j] = hor[i-1][j] + diag[i-1][j]
        if i != 0 and j != 0:
            diag[i][j] = (ver[i-1][j-1] + hor[i-1][j-1] + diag[i-1][j-1] if house[i-1][j] != 1 and house[i][j-1] != 1 else 0)

print(ver[n-1][n-1] + hor[n-1][n-1] + diag[n-1][n-1])
