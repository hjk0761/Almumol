import sys
 
 n = int(sys.stdin.readline().strip())
 arr = []
 for i in range(n):
     age, name = sys.stdin.readline().strip().split()
     arr.append((int(age), name))
 
 sorted_arr = sorted(arr, key=lambda x: x[0])
 
 for i in sorted_arr:
     print(i[0], i[1])
   
