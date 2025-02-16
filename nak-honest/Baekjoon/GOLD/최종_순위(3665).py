import sys
from collections import deque

for _ in range(int(input())):
    n = int(input())
    pasts = list(map(int, sys.stdin.readline().split()))

    inn = [set() for _ in range(n+1)]
    out = [set() for _ in range(n+1)]

    for i in range(len(pasts)):
        for j in range(i + 1, len(pasts)):
            inn[pasts[i]].add(pasts[j])
            out[pasts[j]].add(pasts[i])

    m = int(input())
    for _ in range(m):
        a, b = map(int, sys.stdin.readline().split())
        if b in inn[a] and a in out[b]:
            inn[a].remove(b)
            out[a].add(b)
            out[b].remove(a)
            inn[b].add(a)
        else:
            out[a].remove(b)
            inn[a].add(b)
            inn[b].remove(a)
            out[b].add(a)

    answer = deque()
    no_in = []
    for i in range(1, n+1):
        if not inn[i]:
            no_in.append(i)

    is_impossible = False
    while no_in:
        if len(no_in) != 1:
            is_impossible = True
            break

        node = no_in.pop()
        answer.appendleft(node)

        for next in out[node]:
            inn[next].remove(node)
            if not inn[next]:
                no_in.append(next)

    if is_impossible or len(answer) < n:
        print("IMPOSSIBLE")
    else:
        print(*answer)

