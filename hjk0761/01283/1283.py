import sys

n = int(input())

short = set()
index = [-1 for _ in range(n)]
originCommands = []

for i in range(n):
    originCommand = sys.stdin.readline().strip()
    originCommands.append(originCommand)
    commands = list(map(lambda c:c.lower(), list(originCommand.split())))
    
    temp = 0
    checked = False
    for j in range(len(commands)):
        command = commands[j]
        if command[0] not in short:
            short.add(command[0])
            checked = True
            index[i] = temp
            break
        temp += len(command) + 1
    if checked:
        continue
    for j in range(len(originCommand)):
        c = originCommand[j].lower()
        if c == ' ':
            continue
        if c not in short:
            short.add(c)
            index[i] = j
            break

for i in range(n):
    if index[i] == -1:
        print(originCommands[i])
    else:
        print(originCommands[i][:index[i]] + '[' + originCommands[i][index[i]] + ']' + originCommands[i][index[i]+1:])
