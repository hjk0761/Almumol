import sys
input = sys.stdin.readline

n = int(input().strip())
bead = [int(input().strip()) for _ in range(n)]

_max = max(bead)
_sum = sum(bead)

if _max >= _sum - _max:
    print(2*_max - _sum)
else:
    print(0 if _sum % 2 == 0 else 1)
