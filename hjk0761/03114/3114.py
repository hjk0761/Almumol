import sys
def input(): return sys.stdin.readline().strip()

r, c = map(int, input().split())
trees = [list(input().split(" ")) for _ in range(r)]

apple = [[0 for _ in range(c+1)] for _ in range(r+1)]
banana = [[0 for _ in range(c+1)] for _ in range(r+1)]

for i in range(r):
    for j in range(c):
        apple[i+1][j+1] = apple[i][j+1] + (0 if trees[i][j][0] != 'A' else int(trees[i][j][1:]))
        banana[i+1][j+1] = banana[i+1][j] + (0 if trees[i][j][0] != 'B' else int(trees[i][j][1:]))

dp = [[0 for _ in range(c+1)] for _ in range(r+1)]
for i in range(r):
    for j in range(c):
        a = apple[r][j] - apple[i+1][j]
        b = banana[i][c] - banana[i][j+1]
        dp[i+1][j+1] = max(0 if i==0 or j==0 else (dp[i][j] + apple[r][j] - apple[i][j] + banana[i][c] - banana[i][j]), 
                           0 if i==0 else (dp[i][j+1] + banana[i][c] - banana[i][j+1]), 
                           0 if j==0 else (dp[i+1][j] + apple[r][j] - apple[i+1][j]))

print(dp[r][c])
