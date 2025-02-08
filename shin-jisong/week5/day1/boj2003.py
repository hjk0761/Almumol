import sys

n, m = map(int, sys.stdin.readline().split(" "))
arr = list(map(int, sys.stdin.readline().split(" ")))

ans = 0
count = []

for num in arr:
    count.append(num)
    while sum(count) >= m:
        if sum(count) == m:
            ans += 1
        count.pop(0)
      
print(ans)
