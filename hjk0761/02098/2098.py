import sys
def input(): return sys.stdin.readline().strip()

n = int(input())
w = [list(map(int, input().split())) for _ in range(n)]

def solve(start):
    dp = [[sys.maxsize for _ in range(n)] for _ in range(1<<n)]
    dp[0][start] = 0
    for mask in range(1<<n):
        for prev in range(n):
            if dp[mask][prev] == sys.maxsize:
                continue
            for next in range(n):
                if w[prev][next] == 0:
                    continue
                if (mask>>next)&1:
                    continue
                new_mask = mask | (1<<next)
                new_cost = dp[mask][prev] + w[prev][next]
                if new_cost < dp[new_mask][next]:
                    dp[new_mask][next] = new_cost
    return dp[-1][start]

result = sys.maxsize
for i in range(n):
    result = min(result, solve(i))
print(result)
