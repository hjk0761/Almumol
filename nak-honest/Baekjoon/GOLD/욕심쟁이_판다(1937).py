import sys
from heapq import heappop
from heapq import heapify

n = int(input())
forest = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]

dp = [[1] * n for _ in range(n)]

heap = []
for i in range(n):
    for j in range(n):
        heap.append((-forest[i][j], i, j))

heapify(heap)
udrl = [(0, 1), (0, -1), (1, 0), (-1, 0)]

while heap:
    f, i, j = heappop(heap)
    f = -f

    for diff_i, diff_j in udrl:
        next_i = i + diff_i
        next_j = j + diff_j

        if next_i < 0 or next_i >= n or next_j < 0 or next_j >= n:
            continue
        if f < forest[next_i][next_j]:
            dp[i][j] = max(dp[next_i][next_j] + 1, dp[i][j])

answer = 0

for i in range(n):
    for j in range(n):
        answer = max(answer, dp[i][j])

print(answer)


