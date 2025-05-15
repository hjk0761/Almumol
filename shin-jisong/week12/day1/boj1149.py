import sys
 
 n = int(sys.stdin.readline())
 arr = []
 for _ in range(n):
     item = list(map(int, sys.stdin.readline().split()))
     arr.append(item)
 
 ans = [arr[0]]
 for i in range(1, n):
     item = [min(arr[i][0] + ans[i - 1][1], arr[i][0] + ans[i - 1][2]),
             min(arr[i][1] + ans[i - 1][0], arr[i][1] + ans[i - 1][2]),
             min(arr[i][2] + ans[i - 1][0], arr[i][2] + ans[i - 1][1])]
     ans.append(item)
 
print(min(ans[-1]))
