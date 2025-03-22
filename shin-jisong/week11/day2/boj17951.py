import sys
 
 def can(arr, k, score):
     count = 0
     current_score = 0
     for i in arr:
         current_score += i
         if current_score >= score:
             count += 1
             current_score = 0
         if count >= k:
             return True
     return False
 
 n, k = map(int, sys.stdin.readline().split())
 arr = list(map(int, sys.stdin.readline().split()))
 
 low, high = 0, sum(arr)
 answer = 0
 
 while low <= high:
     mid = (low + high) // 2
     
     if can(arr, k, mid):
         low = mid + 1
         answer = mid
     else:
         high = mid - 1
 
 print(answer)
