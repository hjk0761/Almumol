import sys, re
def input(): return sys.stdin.readline().strip()

n = int(input())
wave = [input() for _ in range(n)]

p = re.compile('(100+1+|01)+')
result = []
for w in wave:
    if p.fullmatch(w):
        result.append("YES")
    else:
        result.append("NO")

for res in result:
    print(res)
