import sys
 
 def findPosition(arr, num):
     low, high = 0, len(arr) - 1
     while low <= high:
         mid = (low + high) // 2
         if arr[mid] >= num:
             high = mid - 1
         else:
             low = mid + 1     
     return low
 
 n = int(sys.stdin.readline().strip())
 arr = list(map(int, sys.stdin.readline().strip().split()))
 answer = []
 
 for num in arr:
     if len(answer) == 0:
         answer.append(num)
     else:
         if answer[-1] < num:
             answer.append(num)
         else:
             answer[findPosition(answer, num)] = num
 
 print(len(answer))
