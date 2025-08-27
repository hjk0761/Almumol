import sys
from collections import deque
def input(): return sys.stdin.readline().strip()

a = input()
b = input()
c = input()

dp = [["" for _ in range(len(b)+1)] for _ in range(len(a)+1)]
dy, dx = [1, 0], [0, 1]
q = deque()
q.append((0, 0, ""))
while q:
    y, x, temp = q.popleft()
    if dp[y][x] != "":
        continue
    dp[y][x] = temp
    if y < len(a) and c[y+x] == a[y]:
        q.append((y+1, x, dp[y][x] + '1'))
    if x < len(b) and c[y+x] == b[x]:
        q.append((y, x+1, dp[y][x] + '2'))

print(dp[len(a)][len(b)])
