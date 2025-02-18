import sys

N, M = map(int, input().split())
maps = [list(map(int, sys.stdin.readline().split())) for _ in range(N)]

dp = [[-sys.maxsize] * M for _ in range(N)]

dp[0][0] = maps[0][0]

for j in range(1, M):
    dp[0][j] = dp[0][j-1] + maps[0][j]

for i in range(1, N):
    mid = [dp[i-1][j] + maps[i][j] for j in range(M)]
    l = mid[:]
    for j in range(1, M):
        l[j] = max(l[j], l[j-1] + maps[i][j])

    r = mid[:]
    for j in range(M-2, -1, -1):
        r[j] = max(r[j], r[j+1] + maps[i][j])

    for j in range(M):
        dp[i][j] = max([l[j], mid[j], r[j]])

print(dp[N-1][M-1])



'''
왼쪽이든 오른쪽이든 한번 가는 순간 돌이킬수 없다.
각 지점에서부터 

 10  25   7   8  13
 68  24 -78  63  32
 12 -69 100 -29 -25
-16 -22 -57 -33  99
  7 -76 -11  77  15


 10  35  42  50  63
172 104  80 158 145
 
 
 10  35  42  50  63
 78 102  24 113 145


 10  35  42  50  63
172 104  80 158  95
 
'''
