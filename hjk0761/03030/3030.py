import sys
def input(): return sys.stdin.readline().strip()

p1, p2 = input().split()
n = int(input())
matches = [list(input().split()) for _ in range(n)]

result = []

def check(m):
    win, loss = 0, 0

    if len(m) > 3:
        return -1, -1

    for idx, s in enumerate(m):
        if win == 2 or loss == 2:
            return -1, -1
        score1, score2 = map(int, s.split(":"))
        if idx == 2:
            if score1 >= 6 and score1 >= score2 + 2:
                win += 1
            elif score2 >= 6 and score2 >= score1 + 2:
                loss += 1
            else:
                return -1, -1
        else:
            if score1 == 7 and score2 == 6:
                win += 1
            elif score2 == 7 and score1 == 6:
                loss += 1
            elif score1 >= 6 and score2 >= 6:
                return -1, -1
            elif score1 >=6 and score1 >= score2 + 2:
                win += 1
            elif score2 >= 6 and score2 >= score1 + 2:
                loss += 1
            else:
                return -1, -1

    if not((win == 2 and loss < win) or (loss == 2 and loss > win)):
        return -1, -1
    
    return win, loss

def federer(win, loss):
    if (p1 == "federer" and loss > 0) or (p2 == "federer" and win > 0):
        return False 
    return True

def solve(m):
    win, loss = check(m)
    if win == -1:
        return "ne"
    if not federer(win, loss):
        return "ne"
    return "da"

for m in matches:
    result.append(solve(m))

for re in result:
    print(re)
