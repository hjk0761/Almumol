import sys
input = sys.stdin.readline

t = int(input().strip())

def solve(n, cost):
    prefixSum = [0 for _ in range(n+1)]
    for i in range(n):
        prefixSum[i+1] = prefixSum[i] + cost[i]
    
    dp = [[sys.maxsize for _ in range(n)] for _ in range(n)]
    for j in range(n):
        for i in range(j, -1, -1):
            if i == j:
                dp[i][j] = cost[i]
                continue
            for k in range(i, j):
                dp[i][j] = min(dp[i][j], dp[i][k] + dp[k+1][j] + prefixSum[j+1] - prefixSum[i])

    value = sys.maxsize
    for i in range(n-1):
        value = min(value, dp[0][i] + dp[i+1][n-1])
    return value

result = []

for _ in range(t):
    k = int(input().strip())
    page = list(map(int, input().strip().split()))
    result.append(solve(k, page))

for re in result:
    print(re)
