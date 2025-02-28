import sys

n = int(sys.stdin.readline())
arr = list(map(int, sys.stdin.readline().rstrip().split()))

stack = []
ans = [-1] * n

for i in range(n):
    while stack and arr[stack[-1]] < arr[i]:
        num = stack.pop()
        ans[num] = arr[i]
    stack.append(i)

print(" ".join(map(str, ans)))
