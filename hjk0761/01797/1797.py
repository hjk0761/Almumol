import sys

n = int(input())
members = [list(map(int, sys.stdin.readline().strip().split())) for _ in range(n)]
members.sort(key=lambda x: x[1])

prefixSum = [0 for _ in range(n+1)]
for i in range(n):
    prefixSum[i+1] = prefixSum[i] + (1 if members[i][0] == 1 else -1)

result = -1

distance = dict()
distance[0] = 0
for i in range(n):
    value = prefixSum[i+1]
    x = members[i][1]
    if value in distance.keys():
        result = max(result, x - members[distance[value]][1])
    else:
        distance[value] = i+1

print(result)
