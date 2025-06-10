import sys
from collections import deque
def input(): return sys.stdin.readline().strip()

n, m, k = map(int, input().split())
graph = [[]]
graph.extend([list(map(int, input().split()))[1:] for _ in range(n)])

sub = []
for g in graph:
    sub.extend(g)

def find_main():
    for i in range(1, n+1):
        if i in sub:
            continue
        return i

main = find_main()

def solve():
    q = deque()
    q.append(main)
    while q:
        cur = q.popleft()
        if len(graph[cur]) > m:
            graph[graph[cur][0]].extend(graph[cur][1:])
            graph[cur] = [graph[cur][0]]
            q.append(graph[cur][0])
        else:
            for next in graph[cur]:
                q.append(next)

solve()
print(1)
print(0)
for i in range(1, len(graph)):
    print(len(graph[i]), end = " ")
    print(*graph[i])
