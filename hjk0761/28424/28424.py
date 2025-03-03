import sys

n, q = map(int, input().split())

alcohol = [int(sys.stdin.readline().strip()) for _ in range(n)]
student = alcohol[:]
next = [i+1 for i in range(n)]
next[n-1] = -1
result = []

def find(cur):
    nextNode = next[cur]
    if nextNode == -1:
        return -1
    if alcohol[nextNode] == 0:
        nextNode = find(nextNode)
    return nextNode

def drink(start, amount):
    cur = start
    while cur != -1:
        if amount == 0:
            break
        d = min(alcohol[cur], amount)
        alcohol[cur] -= d
        amount -= d
        next[cur] = find(cur)
        cur = next[cur]

def do(query):
    if query[0] == 1:
        drink(query[1]-1, query[2])
    else:
        result.append(student[query[1]-1] - alcohol[query[1]-1])

for _ in range(q):
    query = list(map(int, sys.stdin.readline().strip().split()))
    do(query)

for re in result:
    print(re)
