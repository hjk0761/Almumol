import sys
 
 def opposite(num):
     if num == 0:
         return 1
     else:
         return 0
 
 def sticker(n, arr):
     ans = max(arr[0][0], arr[1][0])
     for i in range(1, n):
         for j in range(2):
             if i == 1:
                 arr[j][i] += arr[opposite(j)][i-1]
             else:
                 arr[j][i] += max(arr[opposite(j)][i-1],
                                  arr[opposite(j)][i-2])
             ans = max(ans, arr[j][i])
     return ans
 
 t = int(sys.stdin.readline().rstrip())
 
 for _ in range(t):
     n = int(sys.stdin.readline().rstrip())
     arr = []
     for _ in range(2):
         item = list(map(int, sys.stdin.readline().rstrip().split()))
         arr.append(item)
     print(sticker(n, arr))
   
