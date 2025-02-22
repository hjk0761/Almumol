import sys

n = sys.stdin.readline().strip()
stack = []

for i in range(len(n)):
    stack.append(n[i])
    if len(stack) >= 4 and stack[-4:] == ['P', 'P', 'A', 'P']:
        stack[-4:] = ['P']

if stack == ['P']:
    print("PPAP")
else:
    print("NP")
  
