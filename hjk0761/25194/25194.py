import sys
def input(): return sys.stdin.readline().strip()

n = int(input())
a = list(filter(lambda x: x > 0, map(lambda x: x % 7, list(map(int, input().split())))))

dp = [False for _ in range(7)]

for i in a:
    possible = []
    for j in range(7):
        if dp[j]:
            possible.append((j+i)%7)
    for p in possible:
        dp[p] = True
    dp[i] = True
    if dp[4]:
        break
    

print("YES" if dp[4] else "NO")
