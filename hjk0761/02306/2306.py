import sys
input = sys.stdin.readline

gene = input().strip()
n = len(gene)
dp = [[-1 for _ in range(n+1)] for _ in range(n+1)]

def solve(_from, _to):
    if _from >= _to:
        return 0
    if dp[_from][_to] != -1:
        return dp[_from][_to]
    for mid in range(_from, _to):
        dp[_from][_to] = max(dp[_from][_to], solve(_from, mid) + solve(mid+1, _to))
    if (gene[_from] == 'a' and gene[_to] == 't') or (gene[_from] == 'g' and gene[_to] == 'c'):
        dp[_from][_to] = max(dp[_from][_to], solve(_from+1, _to-1) + 2)
    return dp[_from][_to]

print(solve(0, n-1))
