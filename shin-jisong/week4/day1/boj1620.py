import sys

n, m = map(int, sys.stdin.readline().split())
pokemon = []

for i in range(n):
    name = sys.stdin.readline().strip()
    pokemon.append(name)
  
for i in range(m):
    cmd = sys.stdin.readline().strip()
    if cmd.isdigit():
        print(pokemon[int(cmd) - 1])
    else:
        print(pokemon.index(cmd) + 1)
