import sys

d, p = map(int, sys.stdin.readline().strip().split())

upper = 10 ** d
result = -1
visited = dict()

def find(value, depth):
    global result, visited
    if value >= upper or ((value, depth) in visited.keys() and visited[(value, depth)]):
        return False
    visited[(value, depth)] = True
    if depth == p:
        if value > result:
            result = value
        return True
    for i in range(9, 1, -1):
        if find(value*i, depth+1):
            break
    return False

def solve():
    _min = 2**p
    _max = 9**p

    if _min >= upper:
        print(-1)
    elif _max < upper:
        print(_max)
    else:
        find(1, 0)
        print(result)

solve()
