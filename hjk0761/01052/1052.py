import sys, math
def input(): return sys.stdin.readline().strip()

n, k = map(int, input().split())

def solve(n, k):
    digit = [0 for _ in range(30)]
    i = 0
    while n > 0:
        if n % 2 == 1:
            digit[i] = 1
        i += 1
        n = n >> 1
    one = sum(digit)
    if one <= k:
        return 0
    target = []
    for i in range(30):
        if digit[i] == 1:
            target.append(i)
        if len(target) >= (one - k + 1):
            break
    result = int(math.pow(2, target[0]))
    for i in range(len(target)-1):
        l, r = target[i], target[i+1]
        for j in range(l+1, r):
            result += int(math.pow(2, j))
    return result

print(solve(n, k))
