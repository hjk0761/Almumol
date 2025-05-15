import sys
input = sys.stdin.readline

s = input().strip()
n = len(s)

d = [0 for _ in range(n)]
if s[0] == '(':
    d[0] = 1
else:
    d[0] = -1

for i in range(1, n):
    d[i] = d[i-1] + (1 if s[i] == '(' else -1)

id = [0 for _ in range(n)]
if s[-1] == '(':
    id[-1] = -1
else:
    id[-1] = 1

for i in range(n-2, -1, -1):
    id[i] = id[i+1] + (1 if s[i] == ')' else -1)

def solve():
    count = 0
    if d[-1] == 0:
        return count
    if d[-1] < 0:
        for i in range(n):
            if s[i] == ')':
                count += 1
            if d[i] == -1:
                break
    else:
        for i in range(n-1, -1, -1):
            if s[i] == '(':
                count += 1
            if id[i] == -1:
                break
    return count

print(solve())
