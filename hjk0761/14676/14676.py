import sys
input = sys.stdin.readline

n, m, k = map(int, input().strip().split())
building = [0] * (n+1)
precede = [[] for _ in range(n+1)]

for _ in range(m):
    u, v = map(int, input().strip().split())
    precede[v].append(u)

def solve():
    for _ in range(k):
        order, build = map(int, input().strip().split())
        if order == 1:
            for pre in precede[build]:
                if not building[pre]:
                    return False
            building[build] += 1
        else:
            if not building[build]:
                return False
            building[build] -= 1
    return True

print("King-God-Emperor" if solve() else "Lier!")
