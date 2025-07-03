import sys
def input(): return sys.stdin.readline().strip()
sys.setrecursionlimit(10**6)

n = int(input())
population = list(map(int, input().split()))
graph = [[] for _ in range(n+1)]
for _ in range(n-1):
    u, v = map(int, input().split())
    graph[u].append(v)
    graph[v].append(u)

dp = [[0, 0] for _ in range(n+1)]
visited = [False for _ in range(n+1)]

def find(node):
    if visited[node]:
        return
    visited[node] = True
    dp[node][0] = 0
    dp[node][1] = population[node-1]
    for next in graph[node]:
        if visited[next]:
            continue
        find(next)
        dp[node][0] = dp[node][0] + max(dp[next][0], dp[next][1])
        dp[node][1] = dp[node][1] + dp[next][0]
    
find(1)
print(max(dp[1][0], dp[1][1]))
