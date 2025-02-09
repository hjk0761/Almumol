import sys

n = int(sys.stdin.readline())
m = int(sys.stdin.readline())
arr = list(map(int, sys.stdin.readline().split(" ")))

ans = 0

while len(arr) != 0:
    one = arr.pop(0)
    two = m - one
    if two in arr:
        ans += 1
        arr.remove(two)
      
print(ans)
