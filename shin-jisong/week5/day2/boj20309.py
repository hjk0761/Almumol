import sys

n = int(sys.stdin.readline())
arr = list(map(int, sys.stdin.readline().split()))
ans = "YES"

for i in range(n):
    if (i + 1) % 2 == 1 and arr[i] % 2 != 1:
        ans = "NO"
        break
    if (i + 1) % 2 == 0 and arr[i] % 2 != 0:
        ans = "NO"
        break
      
print(ans)
