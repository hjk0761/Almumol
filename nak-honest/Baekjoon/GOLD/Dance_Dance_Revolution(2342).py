import sys

def get_cost(p, q):
    if p == 0 or q == 0:
        return 2

    if p == q:
        return 1

    if abs(p - q) == 1 or abs(p - q) == 3:
        return 3

    return 4

points = list(map(int, sys.stdin.readline().split()))
points.pop()

dp = [[[sys.maxsize] * 5 for _ in range(5)] for _ in range(len(points))]

dp[0][points[0]][0] = 2
dp[0][0][points[0]] = 2

for i in range(1, len(points)):
    a = points[i]
    b = points[i-1]

    for r in range(5):
        if dp[i - 1][b][r] != sys.maxsize:
            dp[i][b][a] = min(dp[i][b][a], dp[i - 1][b][r] + get_cost(r, a))
        if dp[i-1][b][r] == sys.maxsize:
            continue
        dp[i][a][r] = min(dp[i][a][r], dp[i-1][b][r] + get_cost(b, a))

    for l in range(5):
        if dp[i-1][l][b] != sys.maxsize:
            dp[i][a][b] = min(dp[i][a][b], dp[i - 1][l][b] + get_cost(l, a))
        if dp[i-1][l][b] == sys.maxsize:
            continue
        dp[i][l][a] = min(dp[i][l][a], dp[i-1][l][b] + get_cost(b, a))

answer = sys.maxsize

for l in range(5):
    for r in range(5):
        answer = min(answer, dp[-1][l][r])

print(answer)

'''
, 오른발로 누를떄의 최솟값.

dp[i][0] : i번째를 왼쪽발로 누를때의 최솟값
dp[i][1] : i번째를 오른쪽발로 누를때의 최솟값

dp[i][l][r] : i번째에서 l, r 위치에 발이 있을 때의 최솟값.
points[i] 가 a라 하고, points[i-1]이 b라 하면
dp[i][a][r] = min(dp[i-1][b][r])
dp[i][l][a] = min(dp[i-1][l][b])
0 -> x : 2
x -> x+1 or x-1 : 3
x -> x+2 : 4
x -> x : 1
'''
