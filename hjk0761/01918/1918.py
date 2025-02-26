import sys

formula = list(sys.stdin.readline().strip())

stack = []
result = ""

for cur in formula:
    if cur == '(':
        stack.append(cur)
    elif cur == ')':
        while stack and stack[-1] != '(':
            result += stack.pop()
        stack.pop()
    elif cur in ['*', '/']:
        while stack and (stack[-1] in ['*', '/']):
            result += stack.pop()
        stack.append(cur)
    elif cur in ['+', '-']:
        while stack and stack[-1] != '(':
            result += stack.pop()
        stack.append(cur)
    else:
        result += cur

while stack:
    result += stack.pop()

print(result)
