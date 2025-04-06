import sys
 
 def solution(n, m, num, arr):
     if len(arr) == m:
         print(" ".join(map(str, arr)))
         return
 
     for i in range(num + 1, n + 1):
         arr.append(i)
         solution(n, m, i, arr)
         arr.pop(-1)
 
 n, m = map(int, sys.stdin.readline().rstrip().split())
 
 solution(n, m, 0, [])
