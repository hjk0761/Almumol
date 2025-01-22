n = int(input())

def is_correct(cmd):
    count = 0
    for i in cmd:
        if i == "(":
            count += 1
        elif i == ")":
            count -= 1
        if count < 0:
            return False
    if count == 0:
        return True
    else:
        return False
for i in range(n):
    cmd = input()
    if is_correct(cmd):
        print("YES")
    else:
        print("NO")
