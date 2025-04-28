import sys
from collections import deque
input = sys.stdin.readline

n, m, k = map(int, input().strip().split())
w = int(input().strip())

numToName, nameToNum = dict(), dict()

for _ in range(w):
    num, name = input().strip().split()
    if name not in nameToNum.keys():
        nameToNum[name] = set()
    nameToNum[name].add(int(num))
    numToName[int(num)] = name

graph = [set() for _ in range(n+1)]
for _ in range(m):
    a, b = map(int, input().strip().split())
    graph[a].add(b)
    graph[b].add(a)

def bfs(startName):
    q = deque(nameToNum[startName])
    visited = [(sys.maxsize, -1) for _ in range(n+1)]
    for start in nameToNum[startName]:
        visited[start] = (0, start)
    while q:
        cur = q.popleft()
        if visited[cur][0] > k:
            continue
        for next in graph[cur]:
            if visited[next][0] < sys.maxsize:
                if visited[next][1] == visited[cur][1]:
                    continue
                return visited[next][0] + visited[cur][0] + 1
            visited[next] = (visited[cur][0] + 1, visited[cur][1])
            q.append(next)
    return k+1

def solve():
    for name, nums in nameToNum.items():
        if len(nums) < 2:
            continue
        if bfs(name) <= k:
            return "POWERFUL CODING JungHwan"
    return "so sad"

print(solve())
