import sys

def find_parent(i):
    while i != parent[i]:
        i = parent[i]

    return i

def union(a, b):
    p_a = find_parent(a)
    p_b = find_parent(b)

    if depth[p_a] > depth[p_b]:
        parent[p_b] = p_a
        parent[b] = p_a
    elif depth[p_a] < depth[p_b]:
        parent[p_a] = p_b
        depth[a] = p_b
    else:
        parent[p_b] = p_a
        parent[b] = p_a
        depth[p_a] += 1

N, M, K = map(int, input().split())
C = list(map(int, sys.stdin.readline().split()))
adj = [[] for _ in range(N)]

parent = [i for i in range(N)]
depth = [0] * N

for _ in range(M):
    a, b = map(int, sys.stdin.readline().split())
    a -= 1
    b -= 1
    union(a, b)

for i in range(N):
    parent[i] = find_parent(i)

ind = dict()
j = 0
for i in set(parent):
    ind[i] = j
    j += 1

people = [0] * len(ind)
count = [0] * len(ind)

for i in range(N):
    p_i = ind[parent[i]]
    people[p_i] = people[p_i] + 1
    count[p_i] = count[p_i] + C[i]

# dp[i][p] -> 0~i 까지의 아이들중 p 이하의 수로 만들수 있는 최대 값
dp = [[0] * K for _ in range(len(ind))]

for i in range(len(ind)):
    for p in range(K):
        if people[i] > p:
            dp[i][p] = dp[i - 1][p]
            continue
        dp[i][p] = max(dp[i - 1][p], dp[i - 1][p - people[i]] + count[i])

print(dp[-1][-1])
