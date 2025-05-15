import sys
input = sys.stdin.readline

n, m = map(int, input().strip().split())
weight, value = [0 for _ in range(n)], [0 for _ in range(n)]
for i in range(n):
    w, v = map(int, input().strip().split())
    weight[i] = w
    value[i] = v
k = [int(input().strip()) for _ in range(m)]
largest = max(k)

def solve():
    dp = [[0 for _ in range(largest+1)] for _ in range(2)]
    for i in range(n+1):
        for j in range(largest+1):
            if i == 0 or j == 0:
                dp[i%2][j] = 0
            elif weight[i-1] <= j:
                dp[i%2][j] = max(value[i-1] + dp[(i-1)%2][j-weight[i-1]], dp[(i-1)%2][j])
            else:
                dp[i%2][j] = dp[(i-1)%2][j]
    idx, _max = -1, -1
    for i in range(m):
        eff = dp[n%2][k[i]] / k[i]
        if eff > _max:
            _max = eff
            idx = i
    return idx+1

print(solve())
