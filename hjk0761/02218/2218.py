import sys
input = sys.stdin.readline

n, a, b = map(int, input().strip().split())
score = [list(map(int, input().strip().split())) for _ in range(n)]
aBox = list(map(int, input().strip().split()))
bBox = list(map(int, input().strip().split()))

dp = [[0 for _ in range(b+1)] for _ in range(a+1)]

for i in range(a):
    for j in range(b):
        dp[i+1][j+1] = max(dp[i][j+1], dp[i+1][j], dp[i][j] + score[aBox[i]-1][bBox[j]-1])

print(dp[a][b])
result = []
while a or b:
    if a == 0:
        result.extend([2]*b)
        break
    elif b == 0:
        result.extend([1]*a)
        break
    else:
        if dp[a][b] == dp[a-1][b]:
            result.append(1)
            a -= 1
        elif dp[a][b] == dp[a][b-1]:
            result.append(2)
            b -= 1
        else:
            result.append(3)
            a -= 1
            b -= 1

result.reverse()
print(*result)
