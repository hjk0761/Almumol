import sys

N, M = map(int, input().split())
inn = [set() for _ in range(N)]
out = [set() for _ in range(N)]

for _ in range(M):
    A, B = map(int, sys.stdin.readline().split())
    A -= 1
    B -= 1
    out[A].add(B)
    inn[B].add(A)

answer = []
no_in = []

for i in range(N):
    if not inn[i]:
        no_in.append(i)

while no_in:
    node = no_in.pop()
    answer.append(node+1)

    for next in out[node]:
        inn[next].remove(node)
        if not inn[next]:
            no_in.append(next)

print(*answer)
