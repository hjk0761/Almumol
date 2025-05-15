import sys, bisect
 
 n, m = map(int, sys.stdin.readline().rstrip().split())
 arr = list(map(int, sys.stdin.readline().rstrip().split()))
 for i in range(1, m):
     arr[i] = arr[i] + arr[i-1]
 
 for _ in range(n):
     num = int(sys.stdin.readline().rstrip())
     if num > arr[-1]:
         print("Go away!")
     else:
         print(bisect.bisect_left(arr, num) + 1)
       
