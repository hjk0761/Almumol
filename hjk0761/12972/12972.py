import sys, math
def input(): return sys.stdin.readline().strip()

n = int(input())
l = list(map(int, input().split()))
s = dict()
for d in l:
    if d in s.keys():
        s[d] += 1
    else:
        s[d] = 1
result = []
while len(result) < n:
    m = max(s.keys())
    for idx, d in enumerate(result):
        t = math.gcd(m, d)
        for i in range(2):
            s[t] -= 1
            if s[t] == 0:
                s.pop(t)
    result.append(m)
    s[m] -= 1
    if s[m] == 0:
        s.pop(m)
print(*result)
