import sys

n = int(input())
score = [int(sys.stdin.readline().strip()) for _ in range(n)]
score.sort()

def round(d):
    if d >= int(d) + 0.5:
        return int(d) + 1
    else:
        return int(d)

r = round(n*0.15)
s = sum(score[r:-r])
print(round(s/(n-2*r)) if n > 1 else (0 if n == 0 else score[0]))
