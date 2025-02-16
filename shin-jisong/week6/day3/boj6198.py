import sys

n = int(sys.stdin.readline())
arr = []
ans = 0

for _ in range(n):
    num = int(sys.stdin.readline())
  
    if len(arr) == 0:
        arr.append(num)
    else:
        while len(arr) != 0 and arr[-1] <= num:
            arr.pop(-1)
          
        ans += len(arr)
        arr.append(num)
      
print(ans)
