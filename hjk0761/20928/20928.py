import sys
from collections import deque
def input(): return sys.stdin.readline().strip()

n, m = map(int, input().split())
pos = list(map(int, input().split()))
dis = list(map(int, input().split()))

q = deque(zip(pos[1:], dis[1:]))

count, reachable = 0, pos[0]+dis[0]

def solve():
    global count, reachable
    while q:
        if reachable >= m:
            break
        temp = -1
        while q:
            p, d = q.popleft()
            if p <= reachable:
                temp = max(temp, p+d)
            else:
                q.appendleft((p, d))
                break
        if temp == -1:
            break
        reachable = temp
        count += 1
    if reachable < m:
        return -1
    return count

print(solve())
