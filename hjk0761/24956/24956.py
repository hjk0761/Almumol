import sys

n = int(input())
s = list(sys.stdin.readline().strip())

w, wh, whe, whee = 0, 0, 0, 0

for i in range(n):
    if s[i] == 'W':
        w += 1
    elif s[i] == 'H':
        wh += w
    elif s[i] == 'E':
        whee *= 2
        whee += whe
        whee %= 1000000007
        whe += wh

print(whee)
