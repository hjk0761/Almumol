import sys, heapq
from collections import deque
input = sys.stdin.readline

n = int(input().strip())


problem = [list(map(int, input().strip().split())) for _ in range(n)]
problem.sort(key = lambda x: (x[0], -1*x[1]))
q = deque(problem)
result = 0
eaten = []
count = 0
while q:
    deadline, ramen = q.popleft()
    if deadline == count:
        prev = heapq.heappop(eaten)
        if prev < ramen:
            result -= prev
            result += ramen
            heapq.heappush(eaten, ramen)
        else:
            heapq.heappush(eaten, prev)
        continue
    else:
        result += ramen
        count += 1
        heapq.heappush(eaten, ramen)

print(result)
