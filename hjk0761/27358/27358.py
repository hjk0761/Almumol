import sys
def input(): return sys.stdin.readline()

t = int(input())

def check(stamina, n, d, s, r):
    for i in range(n):
        stamina -= d[i]
        if stamina <= 0:
            return False
        if s[i] == '*':
            stamina *= r[i]
            if stamina > 2**63:
                stamina = 2**63
        else:
            stamina += r[i]
    return True

def binary(left, right, n, d, s, r):
    while left + 1 < right:
        mid = (left + right) // 2
        if check(mid, n, d, s, r):
            right = mid
        else:
            left = mid
    return right

def solve():
    n = int(input())
    d = list(map(int, input().split()))
    s = list(input())
    r = list(map(int, input().split()))
    return binary(-1, 2**63, n, d, s, r)

result = []
for _ in range(t):
    result.append(solve())

for re in result:
    print(re)
