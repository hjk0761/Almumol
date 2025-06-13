import sys, heapq
input = sys.stdin.read
data = input().split()

n, m = int(data[0]), int(data[1])
graph = [[] for _ in range(n+1)]
_max_fallen_time = -1
for i in range(m):
    u, v, d, t = int(data[4*i+2]), int(data[4*i+3]), int(data[4*i+4]), int(data[4*i+5])
    _max_fallen_time = max(_max_fallen_time, t)
    graph[u].append((v, d, t))
    graph[v].append((u, d, t))

def check(t):
    distance = [sys.maxsize] * (n+1)
    q = []
    heapq.heappush(q, (t, 1))
    while q:
        cur_time, cur = heapq.heappop(q)
        if cur == n:
            return False
        if cur_time > distance[cur]:
            continue
        for next, next_dis, next_fallen_time in graph[cur]:
            next_time = cur_time + next_dis
            if next_time > next_fallen_time:
                continue
            if next_time >= distance[next]:
                continue
            distance[next] = next_time
            heapq.heappush(q, (next_time, next))

    return True

def solve():
    left, right = -1, _max_fallen_time + 1
    while left + 1 < right:
        mid = (left + right) // 2
        if check(mid):
            right = mid
        else:
            left = mid
    return left

print(solve())
