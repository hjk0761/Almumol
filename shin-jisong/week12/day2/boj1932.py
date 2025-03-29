import sys
 
 n = int(sys.stdin.readline().rstrip())
 arr = []
 for _ in range(n):
     num = list(map(int, sys.stdin.readline().rstrip().split()))
     arr.append(num)
 
 for i in range(1, n):
     for j in range(len(arr[i])):
         if j == 0:
             arr[i][j] += arr[i-1][0]
         elif j == len(arr[i]) - 1:
             arr[i][j] += arr[i-1][-1]
         else:
             arr[i][j] += max(arr[i-1][j-1], arr[i-1][j])
 
 print(max(arr[-1]))
