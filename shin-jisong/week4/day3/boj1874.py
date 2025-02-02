import sys

n = int(sys.stdin.readline().strip())
arr = []
ans = []
now_num = 0

for i in range(n):
    num = int(sys.stdin.readline().strip())
  
    if now_num < num:
        while now_num < num:
            now_num += 1
            arr.append(now_num)
            ans.append("+")
          
    if len(arr) != 0 and arr[len(arr) - 1] == num:
        arr.pop()
        ans.append("-")
    else:
        ans.clear()
        ans.append("NO")
        break
      
for i in ans:
    print(i)
