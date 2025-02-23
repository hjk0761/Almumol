import sys

n, k = map(int, sys.stdin.readline().strip().split())
arr = list(map(int, str(sys.stdin.readline().strip())))
ans = []
need = n - k

for i in range(n):
    while ans and ans[-1] < arr[i] and len(ans) + (n - i) > need:
        ans.pop()
    ans.append(arr[i])

print("".join(map(str, ans[:need])))
