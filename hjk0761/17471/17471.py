import sys
from collections import deque
from itertools import combinations
def input(): return sys.stdin.readline().strip()

n = int(input())
population = list(map(int, input().split()))
graph = [[]]
graph.extend([list(map(int, input().split()))[1:] for _ in range(n)])

def _dfs(start, visited):
    q = deque()
    q.append(start)
    visited[start] = True
    total = 0
    while q:
        cur = q.popleft()
        total += population[cur-1]
        for next in graph[cur]:
            if visited[next]:
                continue
            visited[next] = True
            q.append(next)
    return total

def dfs(start, visited, nodes):
    q = deque()
    q.append(start)
    visited[start] = True
    total = 0
    while q:
        cur = q.popleft()
        total += population[cur-1]
        for next in graph[cur]:
            if next not in nodes:
                continue
            if visited[next]:
                continue
            visited[next] = True
            q.append(next)
    return total

def count(nodes):
    count, _sum = 0, 0
    visited = [False for _ in range(n+1)]
    for i in nodes:
        if visited[i]:
            continue
        _sum += dfs(i, visited, nodes)
        count += 1
    return count, _sum

def split(n):
    nodes = [i+1 for i in range(n)]
    result = []
    for r in range(1, n):
        for group_a in combinations(nodes, r):
            if 1 not in group_a:
                continue
            group_b = [node for node in nodes if node not in group_a]
            result.append((list(group_a), group_b))
    return result

def solve():
    c, _ = count([i+1 for i in range(n)])
    if c > 2:
        return -1
    if c == 2:
        result = []
        visited = [False for _ in range(n+1)]
        for i in range(1, n+1):
            if visited[i]:
                continue
            result.append(_dfs(i, visited))
        return abs(result[0] - result[1])
    _max = sys.maxsize
    for a, b in split(n):
        a_count, a_sum = count(a)
        b_count, b_sum = count(b)
        if a_count != 1 or b_count != 1:
            continue
        _max = min(_max, abs(a_sum - b_sum))
        if _max == 0:
            break
    return _max if _max < sys.maxsize else -1

print(solve())
