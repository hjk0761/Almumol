import sys
from collections import deque

n, k = map(int, input().split())

visited = [sys.maxsize for _ in range(100001)]

def bfs(start, end):
    visited[start] = 0
    count = 0
    q = deque()
    q.append(start)
    while q:
        cur = q.popleft()
        if cur == end:
            count += 1
            continue
        for next in [cur-1, cur+1, cur*2]:
            if next < 0 or next > 100000:
                continue
            if visited[cur] >= visited[next]:
                continue
            q.append(next)
            visited[next] = min(visited[next], visited[cur] + 1)
    return visited[end], count

time, case = bfs(n, k)
print(time)
print(case)
