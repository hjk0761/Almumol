import sys
input = sys.stdin.readline

x, y = map(int, input().strip().split())

def solve(x, y):
    if x == 2 or y == 2:
        return -1
    turn = (x + y) ** 0.5
    if int(turn) != turn:
        return -1
    turn = int(turn)
    count = 0

    for i in range(turn, 0, -1):
        score = 2*i - 1
        if score > x or x - score == 2:
            continue
        x -= score
        count += 1
        if x == 0:
            break
    
    return count

print(solve(x, y))
