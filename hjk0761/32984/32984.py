import sys
input = sys.stdin.readline

n = int(input().strip())
a = list(map(int, input().strip().split()))
b = list(map(int, input().strip().split()))
c = [0 for _ in range(n)]
for i in range(n):
    c[i] = a[i]//b[i]
    c[i] += (1 if a[i] % b[i] != 0 else 0)
_max = max(c)

def find(day):
    q = 0
    for i in range(n):
        temp = max(0, c[i] - day)
        if temp > 0:
            q += temp
    if day >= q:
        return True
    return False

def binary(left, right):
    while left + 1 < right:
        mid = (left + right) // 2
        if find(mid):
            right = mid
        else:
            left = mid
    return right

print(binary(0, _max+1))
