import sys

n = int(input())

stack = []

for _ in range(n):
    order, amount = map(int, sys.stdin.readline().strip().split())
    if order == 1:
        stack.append(amount)
    else:
        if not stack:
            continue
        stack[-1] = max(stack[-1] - amount, 0)

result = 0
prev = sys.maxsize

while stack:
    cur = stack.pop()
    if cur < prev:
        prev = cur
        result += cur
    else:
        result += prev

print(result)
