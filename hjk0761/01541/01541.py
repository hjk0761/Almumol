import sys

expression = sys.stdin.readline().strip()

sign = ['+', '-']

splited = []

temp = ""

for c in expression:
    if c in sign:
        splited.append(int(temp))
        splited.append(c)
        temp = ""
    else:
        temp += c
splited.append(int(temp))

result = splited[0]
isMinus = False
temp = 0

for i in range(1, len(splited), 2):
    if splited[i] == '+':
        temp += splited[i+1]
    else:
        if isMinus:
            result -= temp
            temp = splited[i+1]
        else:
            result += temp
            isMinus = True
            temp = splited[i+1]
        isMinus = True

if isMinus:
    result -= temp
else:
    result += temp

print(result)
