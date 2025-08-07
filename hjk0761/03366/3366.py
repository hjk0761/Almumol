import sys
def input(): return sys.stdin.readline().strip()

n = int(input())
a = [int(input()) for _ in range(n)]

def solve():
    result = 0
    stack = [sys.maxsize]
    idx = 0
    while idx < n:
        if a[idx] < stack[-1]:
            stack.append(a[idx])
            idx += 1
        else:
            stack.pop()
            if stack[-1] > a[idx]:
                result += a[idx]
            else:
                result += stack[-1]
    if len(stack) > 1:
        for i in range(1, len(stack)-1):
            result += stack[i]
    return result

print(solve())
