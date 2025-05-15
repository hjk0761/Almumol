import sys
 
 n = int(sys.stdin.readline().strip())
 arr = list(map(int, sys.stdin.readline().strip().split()))
 
 sorted_and_set = sorted(set(arr))
 dic_arr = {}
 
 for i in range(len(sorted_and_set)):
     dic_arr[sorted_and_set[i]] = i
 
 ans = []
 for i in arr:
     ans.append(dic_arr[i])
 
 print(" ".join(map(str, ans)))
