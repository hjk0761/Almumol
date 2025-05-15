import sys
input = sys.stdin.readline

n, m = map(int, input().strip().split())
a = list(map(int, input().strip().split()))

maximum = [-1 for _ in range(n)]
maximum[n-1] = a[n-1]
for i in range(n-2, -1, -1):
    maximum[i] = max(maximum[i+1], a[i])

result = a[n-1]-a[0]
for i in range(m+1):
    result = max(result,maximum[n-1-m+i] - a[i])

print(result)
