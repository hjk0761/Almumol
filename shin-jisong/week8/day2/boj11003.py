import sys, heapq

n, l = map(int, sys.stdin.readline().split())
arr = list(map(int, sys.stdin.readline().split()))
heap = []
ans = []

for i in range(n):
    num = arr[i]
    heapq.heappush(heap, (num, i))
    while heap[0][1] < i - l + 1:
        heapq.heappop(heap)
    ans.append(heap[0][0])

print(" ".join(map(str, ans)))
