import sys
from collections import deque
def input(): return sys.stdin.readline().strip()

n, a, b = map(int, input().split())

def find():
    visited = set()
    visited.add((0, 0, 0))
    q = deque()
    q.append((0, 0, 0))
    while q:
        score, turn, double = q.popleft()
        if score >= n:
            return turn
        loss = (score+b, turn+1, double)
        if score+b < n+a and loss not in visited:
            q.append(loss)
            visited.add(loss)
        win = (score+a, turn+1, double)
        if score+a < n+a and win not in visited:
            q.append(win)
            visited.add(win)
        change = (score*2, turn+1, double+1)
        if score*2 < n+a and change not in visited and (turn+1)//10>=(double+1):
            q.append(change)
            visited.add(change)
    return -1

print(find())
