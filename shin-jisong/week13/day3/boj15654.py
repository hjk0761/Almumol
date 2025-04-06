import sys
 
 def solution(n, m, arr, ans):
     if m == len(ans):
         print(" ".join(map(str, ans)))
         return
 
     for num in arr:
         if num not in set(ans):
             ans.append(num)
             solution(n, m, arr, ans)
             ans.pop(-1)
 
 n, m = map(int, sys.stdin.readline().rstrip().split())
 arr = list(map(int, sys.stdin.readline().rstrip().split()))
 arr.sort()
 
 solution(n, m, arr, [])
