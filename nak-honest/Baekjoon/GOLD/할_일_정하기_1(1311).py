import sys

def is_in(bit, i):
    return bit & (1 << i) > 0

N = int(input())
D = [list(map(int, input().split())) for _ in range(N)]

dp = [[-1] * ((1 << N)) for _ in range(N)]

def dfs(i, remain):
    if dp[i][remain] != -1:
        return dp[i][remain]

    if i == 0:
        for j in range(N):
            if is_in(remain, j):
                dp[i][remain] = D[0][j]
                return dp[i][remain]

    dp[i][remain] = sys.maxsize
    for j in range(N):
        if is_in(remain, j):
            dp[i][remain] = min(dp[i][remain], D[i][j] + dfs(i-1, remain - (1 << j)))

    return dp[i][remain]

print(dfs(N-1, (1 << N) - 1))

'''

dp[i][A] : 0~i 사람들이 A 의 일들을 해결하는데 드는 최소 비용

dp[i][A] = min(D[i][j] + dp[i-1][A-vj]) (where j in A)
dp[0][A] = min(D[0][j]) (where j in A)
'''
