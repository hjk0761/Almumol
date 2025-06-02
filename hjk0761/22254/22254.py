import sys, heapq
def input(): return sys.stdin.readline().strip()

n, x = map(int, input().split())
time = list(map(int, input().split()))

def check(count):
    q = []
    idx = 0
    for _ in range(count):
        heapq.heappush(q, time[idx])
        idx += 1
    while idx < n:
        _min = heapq.heappop(q)
        _min += time[idx]
        idx += 1
        heapq.heappush(q, _min)
    _max = max(q)
    return _max <= x

def solve():
    left, right = 0, n
    while left + 1 < right:
        mid = (left + right) // 2
        if check(mid):
            right = mid
        else:
            left = mid
    return right

print(solve())
