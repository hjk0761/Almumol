import sys

l = sys.stdin.readline().strip()

n = len(l)

one = True
palindrome = True

for i in range(1, n):
    if l[i] != l[0]:
        one = False
        break

for i in range(n//2):
    if l[i] != l[n-i-1]:
        palindrome = False
        break

if one:
    print(-1)
elif palindrome:
    print(n-1)
else:
    print(n)
