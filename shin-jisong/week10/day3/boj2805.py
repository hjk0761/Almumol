import sys, bisect
 
 n, m = map(int, sys.stdin.readline().rstrip().split())
 trees = list(map(int, sys.stdin.readline().rstrip().split()))
 
 low, high = 0, max(trees)
 answer = 0
 
 while low <= high:
     mid = (low + high) // 2
     cut_wood = sum(tree - mid for tree in trees if tree > mid)
 
     if cut_wood >= m:
         answer = mid
         low = mid + 1
     else:
         high = mid - 1
 
 print(answer)
