import sys, math
def input(): return sys.stdin.readline().strip()
sys.setrecursionlimit(10**6)

a, b, k = map(int, input().split())
next = [-1 for _ in range(4_000_000)]
dp = [-1 for _ in range(4_000_000)]

def findNext(d):
    temp = 0
    while d > 0:
        cur = d % 10
        temp += int(math.pow(cur, k))
        d //= 10
    return temp

def setPath(d):
    if next[d] != -1:
        return
    s = set()
    s.add(d)
    n = findNext(d)
    next[d] = n
    while n not in s:
        if next[n] != -1:
            break
        s.add(n)
        ne = findNext(n)
        next[n] = ne
        n = ne

def cycle(d):
    _min = dp[d]
    s = set()
    while d not in s:
        s.add(d)
        d = findNext(d)
        _min = min(_min, dp[d])
    for c in s:
        dp[c] = _min

def findMin(d:int, s:set):
    if dp[d] != -1:
        if d in s:
            return d
        return -1
    s.add(d)
    n = findNext(d)
    dp[d] = min(d, n)
    temp = findMin(n, s)
    dp[d] = min(dp[d], dp[n])
    return temp

def solve(d):
    setPath(d)
    s = set()
    temp = findMin(d, s)
    if temp != -1:
        cycle(temp)
    return dp[d]

result = 0
for i in range(a, b+1):
    result += solve(i)

print(result)
