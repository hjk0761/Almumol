import sys, heapq
def input(): return sys.stdin.readline().strip()

n, k = map(int, input().split())
jewel = [list(map(int, input().split())) for _ in range(n)]
bag = [int(input()) for _ in range(k)]
heapq.heapify(jewel)
bag.sort()
q = []

def solve():
    result = 0
    for b in bag:
        while jewel:
            next = heapq.heappop(jewel)
            if next[0] > b:
                heapq.heappush(jewel, next)
                break
            heapq.heappush(q, -1 * next[1])
        if q:
            result += -1 * heapq.heappop(q)
    return result

print(solve())
