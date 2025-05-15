import sys

n = int(sys.stdin.readline())
stack = []
ans = 0

for _ in range(n):
    h = int(sys.stdin.readline())
    count = 1
    
    while stack and stack[-1][0] <= h:
        popped_height, popped_count = stack.pop()
        ans += popped_count
        if popped_height == h:
            count += popped_count

    if stack:
        ans += 1

    stack.append((h, count))

print(ans)
