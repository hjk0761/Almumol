import sys
import heapq

n = int(sys.stdin.readline())
arr = []

for i in range(n):
    num = int(sys.stdin.readline())
    if num == 0:
        if len(arr) == 0:
            print(0)
        else:
            print(heapq.heappop(arr))
    else:
        heapq.heappush(arr, num)
