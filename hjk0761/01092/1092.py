import sys
def input(): return sys.stdin.readline().strip()

n = int(input())
crane = list(map(int, input().split()))
m = int(input())
box = list(map(int, input().split()))

crane.sort(reverse=True)
box.sort(reverse=True)

def solve():
    if box[0] > crane[0]:
        return -1
    count = 0
    while box:
        for c in crane:
            for b in box:
                if c >= b:
                    box.remove(b)
                    break
        count += 1
    return count

print(solve())
