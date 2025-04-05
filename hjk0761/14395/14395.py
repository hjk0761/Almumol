import sys
from collections import deque
input = sys.stdin.readline
sign = ['*', '+', '-', '/']

s, t = map(int, input().strip().split())

def bfs(start, end):
    if start == end:
        return 0
    q = deque()
    q.append((start, ""))
    visited = set()
    result = "-1"
    while q:
        cur, signs = q.popleft()
        if cur == end:
            result = signs
            break
        for idx, next in enumerate([cur*cur, cur*2, 0, 1]):
            if next < 0 or next > end:
                continue
            if next in visited:
                continue
            visited.add(next)
            q.append((next, signs+sign[idx]))
    return result

print(bfs(s, t))
