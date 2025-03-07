import sys

n = int(sys.stdin.readline().strip())
arr = set()

for i in range(n):
    arr.add(sys.stdin.readline().strip())

sorted_arr = sorted(list(arr), key=lambda x: (len(x), x))

print("\n".join(sorted_arr))
