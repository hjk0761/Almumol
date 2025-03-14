mport sys
 
 n = int(sys.stdin.readline().strip())
 arr = set(map(int, sys.stdin.readline().strip().split()))
 m = int(sys.stdin.readline().strip())
 check = list(map(int, sys.stdin.readline().strip().split()))
 ans = []
 
 for i in check:
     if i in arr:
         ans.append(1)
     else:
         ans.append(0)
 
 print(" ".join(map(str, ans)))
