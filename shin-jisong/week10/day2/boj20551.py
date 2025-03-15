import sys, bisect
 
 n, m = map(int, sys.stdin.readline().rstrip().split())
 arr = []
 
 for _ in range(n):
     arr.append(int(sys.stdin.readline().rstrip()))
 
 arr.sort()
 set_arr = set(arr)
 
 for _ in range(m):
     num = int(sys.stdin.readline().rstrip())
     if num not in set_arr:
         print(-1)
     else:
         print(bisect.bisect_left(arr, num))
