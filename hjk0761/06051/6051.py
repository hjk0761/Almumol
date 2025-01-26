import sys

n = int(input())

stack = [[-1, 0]] * (n+1)

prev = 0

for idx in range(1, n+1):
    commands = list(sys.stdin.readline().strip().split())
    if commands[0] == 'a':
        stack[idx] = [int(commands[1]), prev]
        prev = idx
    elif commands[0] == 's':
        stack[idx] = [stack[prev][0], prev]
        prev = stack[prev][1]
    else:
        stack[idx] = [stack[prev][0], prev]
        prev = stack[int(commands[1])][1]
    
    print(stack[prev][0])
