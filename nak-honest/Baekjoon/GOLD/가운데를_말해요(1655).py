import sys
from heapq import heappush
from heapq import heappop

N = int(input())

max_heap = []
min_heap = []

for i in range(1, N + 1):
    num = int(sys.stdin.readline())

    if max_heap and num >= -max_heap[0]:
        if len(max_heap) == (i + 1) // 2:
            heappush(min_heap, num)
        else:
            heappush(min_heap, num)
            heappush(max_heap, -heappop(min_heap))
    else:
        heappush(max_heap, -num)
        if len(max_heap) > (i + 1) // 2:
            heappush(min_heap, -heappop(max_heap))

    print(-max_heap[0])

