import sys
import bisect

n, m = map(int, sys.stdin.readline().strip().split())
arr = list(map(int, sys.stdin.readline().strip().split()))
arr.sort()

for _ in range(m):
    q = list(map(int, sys.stdin.readline().strip().split()))

    if q[0] == 1:
        idx = bisect.bisect_left(arr, q[1])
        print(n - idx)

    elif q[0] == 2:
        idx = bisect.bisect_right(arr, q[1])
        print(n - idx)

    elif q[0] == 3:
        left_idx = bisect.bisect_left(arr, q[1])
        right_idx = bisect.bisect_right(arr, q[2])
        print(right_idx - left_idx)
    
