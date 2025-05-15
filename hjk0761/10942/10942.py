import sys
sys.setrecursionlimit(10**6)

n = int(input())
array = list(map(int, sys.stdin.readline().strip().split()))

dp = [[-1 for _ in range(n)] for _ in range(n)]
for i in range(n):
    dp[i][i] = 1

def find(s, e):
    if abs(s-e) <= 1:
        if dp[s-1][e-1] != -1:
            return dp[s-1][e-1]
        if array[s-1] == array[e-1]:
            dp[s-1][e-1] = 1
        else:
            dp[s-1][e-1] = 0
        return dp[s-1][e-1]
    if dp[s-1][e-1] != -1:
        return dp[s-1][e-1]
    dp[s-1][e-1] = 1 if (array[s-1] == array[e-1]) and (find(s+1, e-1)) else 0
    return dp[s-1][e-1]

result = []
m = int(input())
for _ in range(m):
    s, e = map(int, sys.stdin.readline().strip().split())
    result.append(find(s, e))

for re in result:
    print(re)
