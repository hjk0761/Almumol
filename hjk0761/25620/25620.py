import sys, heapq
input = sys.stdin.readline

n, q = map(int, input().strip().split())
slime = list(map(int, input().strip().split()))
liquid = [list(map(int, input().strip().split())) for _ in range(q)]
zero = 0
heapq.heapify(slime)
while slime:
    cur = heapq.heappop(slime)
    if cur == 0:
        zero += 1
    else:
        heapq.heappush(slime, cur)
        break

for x, y in liquid:
    if x == 0 or y == 1:
        continue
    if y == 0:
        while slime:
            cur = heapq.heappop(slime)
            if cur > x:
                heapq.heappush(slime, cur)
                break
            else:
                zero += 1
        continue
    next = []
    while slime:
        cur = heapq.heappop(slime)
        if cur <= x:
            next.append(cur * y)
        else:
            heapq.heappush(slime, cur)
            break
    for n in next:
        heapq.heappush(slime, n)

result = [0] * zero
while slime:
    result.append(heapq.heappop(slime))
print(*result)
