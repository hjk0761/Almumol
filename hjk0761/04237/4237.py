import sys

t = int(input())

def find(n, a):
    count = 1
    prev = a[0]
    downward = True
    for i in range(1, n):
        next = a[i]
        if downward and prev > next:
            count += 1
            downward = False
        elif not downward and prev < next:
            count += 1
            downward = True
        prev = next
    return count

result = []

for _ in range(t):
    temp = list(map(int, sys.stdin.readline().strip().split()))
    n = temp[0]
    a = temp[1:]
    result.append(find(n, a))

for re in result:
    print(re)
