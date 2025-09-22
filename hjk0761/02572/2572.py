import sys
def input(): return sys.stdin.readline().strip()

n = int(input())
card = list(input().split())
m, k = map(int, input().split())
graph = [[] for _ in range(m+1)]
for _ in range(k):
    a, b, road = input().split()
    graph[int(a)].append((road, int(b)))
    graph[int(b)].append((road, int(a)))

dp = [[-1 for _ in range(m+1)] for _ in range(n)]

for i in range(n):
    if i == 0:
        for color, next in graph[1]:
            dp[0][next] = 10 if color == card[i] else 0
        continue
    for cur in range(1, m+1):
        if dp[i-1][cur] == -1:
            continue
        for color, next in graph[cur]:
            temp = 10 if color == card[i] else 0
            dp[i][next] = max(dp[i][next], temp + dp[i-1][cur])

print(0 if max(dp[-1]) == -1 else max(dp[-1]))
