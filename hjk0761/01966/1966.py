import sys
from collections import deque

t = int(input())

for _ in range(t):
    n, m = map(int, sys.stdin.readline().strip().split())
    docs = list(map(int, sys.stdin.readline().strip().split()))
    ordered = docs[:]
    ordered.sort()
    q = deque()
    for i in range(n):
        q.append((docs[i], i))
    count = 0
    while True:
        num, order = q.popleft()
        if num == ordered[-1]:
            count += 1
            ordered.pop()
            if order == m:
                print(count)
                break
        q.append((num, order))
