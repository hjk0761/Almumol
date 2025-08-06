import sys
def input(): return sys.stdin.readline().strip()

n, r, c, w = map(int, input().split())
classes = [[0 for _ in range(c+w-1)] for _ in range(r+w-1)]
for _ in range(n):
    y, x = map(int, input().split())
    classes[y+w//2-1][x+w//2-1] = 1

dp = [[0 for _ in range(c+w)] for _ in range(r+w)]

dp[1][1] = classes[0][0]

for i in range(r+w-1):
    for j in range(c+w-1):
        if i == 0 and j == 0:
            continue
        dp[i+1][j+1] = dp[i][j+1] + dp[i+1][j] - dp[i][j] + classes[i][j]

ry, rx, value = -1, -1, -1

for i in range(r):
    for j in range(c):
        if classes[i+w//2][j+w//2] == 1:
            continue
        temp = dp[i+w][j+w] - dp[i+w][j] - dp[i][j+w] + dp[i][j]
        if temp > value:
            value = temp
            ry, rx = i, j

print(value)
print(ry+1, rx+1)
