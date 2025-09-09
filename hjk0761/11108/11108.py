import sys
def input(): return sys.stdin.readline().strip()

def solve():
    n = int(input())
    programs = [list(map(int, input().split())) for _ in range(n)]
    programs.sort(key = lambda x: (x[0]+x[1], x[0]))
    idx = 0
    dp = [0 for _ in range(10081)]
    for i in range(1, len(dp)):
        dp[i] = dp[i-1]
        while idx < n and programs[idx][0] + programs[idx][1] <= i:
            dp[programs[idx][0]+programs[idx][1]] = max(dp[programs[idx][0]+programs[idx][1]], dp[programs[idx][0]]+programs[idx][2])
            idx += 1
    return dp[-1]

t = int(input())
result = []
for _ in range(t):
    result.append(solve())

for re in result:
    print(re)
