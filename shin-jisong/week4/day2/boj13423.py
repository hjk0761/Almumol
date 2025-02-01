import sys

def count_dot(arr):
    count = 0
    n = len(arr)
  
    for j in range(1, n - 1):
        diff_count = {}
        for i in range(j):
            diff = arr[j] - arr[i]
            diff_count[diff] = True
        for k in range(j + 1, n):
            diff = arr[k] - arr[j]
            if diff in diff_count:
                count += 1
    return count
  
t = int(sys.stdin.readline())
for i in range(t):
    n = int(sys.stdin.readline())
    arr = list(map(int, sys.stdin.readline().split()))
    arr.sort()
    print(count_dot(arr))
