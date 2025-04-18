import sys

n = int(input())
liquid = list(map(int, sys.stdin.readline().strip().split()))

left, right = 0, n-1
result = sys.maxsize
base, acid = -1, -1

while left < right:
    if liquid[left] > 0:
        right = left + 1
    elif liquid[right] < 0:
        left = right - 1
    mixed = liquid[left] + liquid[right]
    if abs(mixed) < abs(result):
        base, acid = left, right
        result = mixed
    if mixed == 0:
        break
    elif mixed > 0:
        right -= 1
    else:
        left += 1

print(liquid[base], liquid[acid])
