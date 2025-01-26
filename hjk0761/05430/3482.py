import sys
from collections import deque

t = int(input())

def parsing(l):
    if len(l) == 2:
        return deque()
    return deque(l[1:-1].split(","))

def making(d: deque, first: bool):
    temp = "["
    l = list(d)
    if not first:
        l.reverse()
    temp += ','.join(l)
    temp += "]"
    return temp

result = []

for _ in range(t):
    first = True
    imp = False
    p = sys.stdin.readline().strip()
    n = int(sys.stdin.readline().strip())
    x = parsing(sys.stdin.readline().strip())
    for f in p:
        if f == 'R':
            first = not first
        else:
            if len(x) == 0:
                result.append('error')
                imp = True
                break
            if first:
                x.popleft()
            else:
                x.pop()
    if not imp:
        result.append(making(x, first))

for re in result:
    print(re)
