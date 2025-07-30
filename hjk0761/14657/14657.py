import sys
def input(): return sys.stdin.readline().strip()

n, t = map(int, input().split())
graph = [[] for _ in range(n+1)]

for _ in range(n-1):
    u, v, d = map(int, sys.stdin.readline().strip().split())
    graph[u].append((d, v))
    graph[v].append((d, u))

def cal(node):
    visited = [False for _ in range(n+1)]
    stack = [(0, 0, node)]
    midx, mdepth, mdist = -1, 0, 0
    while stack:
        distance, depth, cur = stack.pop()
        if visited[cur]:
            continue
        if depth > mdepth:
            midx = cur
            mdepth = depth
            mdist = distance
        elif depth == mdepth and distance < mdist:
            midx = cur
            mdist = distance

        visited[cur] = True
        for dist, next in graph[cur]:
            if visited[next]:
                continue
            stack.append((distance + dist, depth+1, next))
    return midx, mdist

def solve():
    idx, _ = cal(1)
    _, time = cal(idx)
    if time % t == 0:
        return time//t
    else:
        return time//t + 1

print(solve())
