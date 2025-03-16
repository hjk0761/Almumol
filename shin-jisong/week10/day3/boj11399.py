import sys
 
 n = int(sys.stdin.readline().rstrip())
 arr = list(map(int, sys.stdin.readline().rstrip().split()))
 
 arr.sort()
 
 ans = [0]
 
 for num in arr:
     ans.append(ans[-1] + num)
 
 print(sum(ans))
