import sys

n, m = map(int, sys.stdin.readline().split())
hear = set()
see = set()

for i in range(n):
    name = sys.stdin.readline().strip()
    hear.add(name)
  
for i in range(m):
    name = sys.stdin.readline().strip()
    see.add(name)
  
hear_and_see = sorted(hear & see)
print(len(hear_and_see))
for name in hear_and_see:
    print(name)
