import sys
input = sys.stdin.readline

n = int(input().strip())
wire = [list(map(int, input().strip().split())) for _ in range(n)]
wire.sort(key = lambda x: x[0])
dest = [x[1] for x in wire]

def find(i):
    result = []
    for j in range(i-1, -1, -1):
        if dest[j] < dest[i]:
            result.append(j)
    return result
dp = [1 for _ in range(n)]
for i in range(n):
    less = find(i)
    for j in less:
        dp[i] = max(dp[i], dp[j] + 1)
wire.reverse()
dp1 = [1 for _ in range(n)]
for i in range(n):
    less = find(i)
    for j in less:
        dp1[i] = max(dp1[i], dp1[j] + 1)
print(n - max(max(dp), max(dp1)))
