import sys
def input(): return sys.stdin.readline().strip()

n = int(input())
dp = [0 for _ in range(2000001)]
dp[1] = 1
for i in range(2, 2000001):
    dp[i] = 1 + dp[i-dp[dp[i-1]]]

def solve():
    sum = 0
    for i in range(1, 2000001):
        sum += dp[i]
        if sum >= n:
            return i
    return n
print(solve())
