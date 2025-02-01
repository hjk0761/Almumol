import sys

N = int(input())
H = list(map(int, sys.stdin.readline().split()))
stack = []
count = [0] * N
nearest = [-1] * N

for i in range(N):
    if not stack:
        stack.append((H[i], i))
        continue

    while stack and stack[-1][0] <= H[i]:
        stack.pop()

    if stack:
        nearest[i] = stack[-1][1] + 1
        count[i] += len(stack)

    stack.append((H[i], i))

stack.clear()
for i in range(N-1, -1, -1):
    if not stack:
        stack.append((H[i], i))
        continue

    while stack and stack[-1][0] <= H[i]:
        stack.pop()

    if stack:
        if nearest[i] == -1:
            nearest[i] = stack[-1][1] + 1
        elif abs(i + 1 - nearest[i]) > abs(i + 1 - (stack[-1][1] + 1)):
            nearest[i] = stack[-1][1] + 1
        count[i] += len(stack)

    stack.append((H[i], i))

answer = []
for i in range(N):
    if count[i] == 0:
        answer.append("0")
    else:
        answer.append(" ".join([str(count[i]), str(nearest[i])]))

print(*answer, sep='\n')
