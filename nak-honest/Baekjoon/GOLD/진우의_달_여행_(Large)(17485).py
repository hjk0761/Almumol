import sys

N, M = map(int, input().split())
maps = [list(map(int, sys.stdin.readline().split())) for _ in range(N)]
dirs = [(1, -1), (1, 0), (1, 1)]

# j = -1, M 일때 sys.maxsize 로 두기 위해 M + 1 로 정의
dp = [[[sys.maxsize] * (M + 1) for _ in range(N)] for _ in range(3)]

for j in range(M):
    for dir in range(3):
        dp[dir][0][j] = maps[0][j]

for i in range(1, N):
    for j in range(M):
        dp[0][i][j] = min(dp[1][i - 1][j], dp[2][i - 1][j + 1]) + maps[i][j]
        dp[1][i][j] = min(dp[0][i - 1][j - 1], dp[2][i - 1][j + 1]) + maps[i][j]
        dp[2][i][j] = min(dp[0][i - 1][j - 1], dp[1][i - 1][j]) + maps[i][j]

answer = sys.maxsize

for j in range(M):
    for dir in range(3):
        answer = min(answer, dp[dir][N-1][j])
print(answer)
'''
i, j 까지 도달하는데 최소 비용
dp[0][i][j] = 이전이 dirs[0] 가 아닐 때의 최소 비용
dp[1][i][j] = ...

dp[0][i][j] = min(dp[1][i-1][j], dp[2][i-1][j+1]) + maps[i][j]
dp[1][i][j] = min(dp[0][i-1][j-1], dp[2][i-1][j+1]) + maps[i][j]
dp[2][i][j] = min(dp[0][i-1][j-1], dp[1][i-1][j]) + maps[i][j]

'''
