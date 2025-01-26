n, k = map(int, input().split())
arr = [i for i in range(1, n + 1)]
ans = []

while len(arr) > 0:
    if len(arr) < k:
        i = k % len(arr)
    else:
        i = k
    arr = arr[i-1:] + arr[:i-1]
    ans.append(arr.pop(0))
  
print("<" + ", ".join(map(str, ans)) + ">")
