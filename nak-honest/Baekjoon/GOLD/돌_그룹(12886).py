from collections import deque

A, B, C = map(int, input().split())

v = set()
q = deque()
node = tuple(sorted([A, B, C]))
q.append(node)
v.add(node)
answer = 0

while q:
    a, b, c = q.popleft()

    if a == b and b == c:
        answer = 1
        break

    for x, y, z in [(a, b, c), (b, c, a), (a, c, b)]:
        next = tuple(sorted([2 * x, y - x, z]))
        if next not in v:
            v.add(next)
            q.append(next)

print(answer)

