import sys

n, k = map(int, sys.stdin.readline().split(" "))

arr = [i for i in range(1, n + 1)]
ans = []
index = 0

while len(arr) != 0:
    index = index + k - 1
    if index >= len(arr):
        index = index % len(arr)
      
    ans.append(str(arr.pop(index)))
  
print("<",", ".join(ans)[:],">", sep='')
