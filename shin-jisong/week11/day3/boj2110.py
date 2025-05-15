import sys
 
 def can(arr, d, c):
     count = 1
     last_installed = arr[0]
 
     for i in range(1, len(arr)):
         if arr[i] - last_installed >= d:
             count += 1
             last_installed = arr[i]
         if count >= c:
             return True
 
 n, c = map(int, sys.stdin.readline().split())
 arr = []
 
 for _ in range(n):
     num = int(sys.stdin.readline())
     arr.append(num)
 
 arr.sort()
 
 low, high = 0, arr[-1] - arr[0]
 answer = 0
 
 while low <= high:
     mid = (low + high) // 2
 
     if can(arr, mid, c):
         answer = mid
         low = mid + 1
     else:
         high = mid - 1
 
 print(answer)
