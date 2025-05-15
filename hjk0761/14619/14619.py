import sys
input = sys.stdin.readline

n, m = map(int, input().strip().split())
h = list(map(int, input().strip().split()))
graph = [[] for _ in range(n+1)]
for _ in range(m):
    u, v = map(int, input().strip().split())
    graph[u].append(v)
    graph[v].append(u)
dp = [[sys.maxsize for _ in range(501)] for _ in range(n+1)]

for i in range(n):
    dp[i+1][0] = h[i]
for j in range(1, 501):
    for i in range(n):
        for k in graph[i+1]:
            dp[i+1][j] = min(dp[i+1][j], dp[k][j-1])

t = int(input().strip())
result = []
for _ in range(t):
    a, k = map(int, input().strip().split())
    result.append(dp[a][k] if dp[a][k] < sys.maxsize else -1)

for re in result:
    print(re)
