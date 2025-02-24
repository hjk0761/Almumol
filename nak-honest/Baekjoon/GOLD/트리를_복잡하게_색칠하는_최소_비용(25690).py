import sys
from collections import deque
from copy import deepcopy

root = 0
n = int(input())
edges = [list(map(int, sys.stdin.readline().split())) for _ in range(n - 1)]
wbs = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]

parents = [-1] * n
children = [set() for _ in range(n)]
leafs = set()

for p, c in edges:
    parents[c] = p
    children[p].add(c)

for i in range(n):
    if not children[i]:
        leafs.add(i)

dp = [[sys.maxsize] * 2 for _ in range(n)]
rest_children = deepcopy(children)
q = deque()

for leaf in leafs:
    dp[leaf][0] = wbs[leaf][0]
    dp[leaf][1] = wbs[leaf][1]
    parent = parents[leaf]
    rest_children[parent].remove(leaf)
    if not rest_children[parent]:
        q.append(parent)

while q:
    node = q.popleft()
    dp[node][0] = wbs[node][0]
    dp[node][1] = wbs[node][1]
    for child in children[node]:
        dp[node][0] += min(dp[child][0], dp[child][1])
        dp[node][1] += dp[child][0]

    parent = parents[node]
    if parent == -1:
        break
    rest_children[parent].remove(node)
    if not rest_children[parent]:
        q.append(parent)

print(min(dp[0]))



'''
부모를 칠하면 자식을 못칠한다.
부모 노드를 블랙으로 칠했을 때의 최댓값 = 자식 노드 전부를 화이트로 칠했을 때의 최댓값 + 부모 노드 블랙 
부모 노드를 화이트로 칠했을 때의 최댓값 = 자식 노드 전부를 최대 색깔로 칠했을 때의 최댓값 + 부모 노드 화이트
'''

