import sys
input = sys.stdin.readline

n, k, t = map(int, input().strip().split())
a = list(map(int, input().strip().split()))

a.sort()

left, right = 0, n-1
count = 0
possible = True
while left <= right:
    if left == right and a[left]:
        possible = False
        break
    move = min(a[left], k-a[right])
    count += move
    a[left] -= move
    a[right] += move
    if count > t:
        possible = False
        break
    if a[left] == 0:
        left += 1
    if a[right] == k:
        right -= 1

print("YES" if possible else "NO")
