import sys
from collections import deque

n = int(input())
q = deque()

for _ in range(n):
    command = list(sys.stdin.readline().strip().split())
    if command[0] == 'push':
        q.append(int(command[1]))
    elif command[0] == 'pop':
        print(q.popleft() if len(q) != 0 else -1)
    elif command[0] == 'size':
        print(len(q))
    elif command[0] == 'empty':
        print(1 if len(q) == 0 else 0)
    elif command[0] == 'front':
        print(q[0] if len(q) != 0 else -1)
    elif command[0] == 'back':
        print(q[-1] if len(q) != 0 else -1)
