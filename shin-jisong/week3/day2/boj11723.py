import sys

m = int(sys.stdin.readline())
s = set()

for i in range(m):
    cmd = sys.stdin.readline()
    if cmd.startswith("add"):
        num = int(cmd.split()[1])
        s.add(num)
    elif cmd.startswith("remove"):
        num = int(cmd.split()[1])
        s.discard(num)
    elif cmd.startswith("check"):
        num = int(cmd.split()[1])
        if num in s:
            print(1)
        else:
            print(0)
    elif cmd.startswith("toggle"):
        num = int(cmd.split()[1])
        if num in s:
            s.remove(num)
        else:
            s.add(num)
    elif cmd.startswith("all"):
        s = set(range(1, 21))
    elif cmd.startswith("empty"):
        s = set()
