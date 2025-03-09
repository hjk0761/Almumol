import sys
 
 n = int(sys.stdin.readline().strip())
 arr_n = list(map(int, sys.stdin.readline().strip().split()))
 m = int(sys.stdin.readline().strip())
 arr_m = list(map(int, sys.stdin.readline().strip().split()))
 
 set_n = set(arr_n)
 ans = []
 for i in arr_m:
     if i in set_n:
         ans.append(1)
     else:
         ans.append(0)
 
 print("\n".join(map(str, ans)))
