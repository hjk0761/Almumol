import sys, heapq
def input(): return sys.stdin.readline().strip()
n = int(input())
assignment = [list(map(int, input().split())) for _ in range(n)]
assignment.sort(key = lambda x: x[0], reverse=True)

def solve():
    q = []
    result = 0
    day = assignment[0][0]
    idx = 0
    while day >= 1:
        while idx < n and assignment[idx][0] >= day:
            heapq.heappush(q, -1 * assignment[idx][1])
            idx += 1
        if q:
            result += -1 * heapq.heappop(q)
        day -= 1
    return result

print(solve())
