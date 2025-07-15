import sys
def input(): return sys.stdin.readline().strip()

n = int(input())
weight = list(map(int, input().split()))
weight.sort()
def solve():
    s = 0
    for i in range(n):
        if weight[i] <= s + 1:
            s += weight[i]
        else:
            break
    return s + 1
print(solve())
