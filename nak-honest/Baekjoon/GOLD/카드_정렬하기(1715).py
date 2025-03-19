from heapq import heappop
from heapq import heappush
import sys

N = int(input())
heap = []

for _ in range(N):
    heappush(heap, int(sys.stdin.readline()))

answer = 0
while len(heap) > 1:
    a = heappop(heap)
    b = heappop(heap)
    answer += a + b

    heappush(heap, a + b)

print(answer)


