import sys

n = int(sys.stdin.readline())
lines = []

for i in range(n):
    lines.append(tuple(map(int, input().split())))
  
lines.sort()
left = lines[0][0]
right = lines[0][1]
ans = 0

for i in range(1, n):
    x = lines[i][0]
    y = lines[i][1]
  
    if y <= right:
        continue
    elif x <= right < y:
        right = y
    elif right < x:
        ans += (right - left)
        left = x
        right = y
      
ans += right - left
print(ans)
