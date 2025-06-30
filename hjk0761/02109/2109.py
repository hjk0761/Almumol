import sys, heapq
def input(): return sys.stdin.readline().strip()

def solve():
    n = int(input())
    if n == 0:
        return 0
    lecture = [list(map(int, input().split())) for _ in range(n)]
    lecture.sort(key = lambda x: x[1], reverse=True)
    q = []
    result = 0
    day = lecture[0][1]
    idx = 0
    while day >= 1:
        while idx < n and lecture[idx][1] >= day:
            heapq.heappush(q, -1 * lecture[idx][0])
            idx += 1
        if q:
            result += -1 * heapq.heappop(q)
        day -= 1
    return result

print(solve())
