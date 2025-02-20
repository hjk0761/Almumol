import sys

n = sys.stdin.readline().strip()
ans = ""
stack = []

priority = {"(": 0, "+": 1, "-": 1, "*": 2, "/": 2}

for i in n:
    if i.isalpha():
        ans += i
    elif i == "(":
        stack.append(i)
    elif i == ")":
        while stack and stack[-1] != "(":
            ans += stack.pop()
        stack.pop()
    else:
        while stack and priority[stack[-1]] >= priority[i]:
            ans += stack.pop()
        stack.append(i)

while stack:
    ans += stack.pop()

print(ans)
