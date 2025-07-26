import sys
from collections import deque
def input(): return sys.stdin.readline().strip()

n, k = map(int, input().split())
fountain = list(map(int, input().split()))
dx = [1, -1]

def solve():
    score = 0
    count = 0
    s = set()
    for f in fountain:
        s.add(f-1)
        s.add(f+1)
    q = deque()
    for d in s:
        q.append((d, 1))
    visited = set(fountain)
    while q:
        cur, dist = q.popleft()
        if count == k:
            return score
        if cur in visited:
            continue
        count += 1
        score += dist
        visited.add(cur)
        for i in range(2):
            next = cur + dx[i]
            if next in visited:
                continue
            q.append((next, dist+1))

print(solve())
