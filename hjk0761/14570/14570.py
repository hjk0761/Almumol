import sys
input = sys.stdin.readline

n = int(input().strip())
tree = [[-1, -1] for _ in range(n+1)]
for i in range(n):
    tree[i+1] = list(map(int, input().strip().split()))
k = int(input().strip())

def dfs(k):
    cur = 1
    while True:
        left, right = tree[cur]
        if left == -1 and right == -1:
            return cur
        elif left == -1:
            cur = right
        elif right == -1:
            cur = left
        else:
            if k % 2 == 0:
                cur = right
                k = k//2
            else:
                cur = left
                k = (k+1)//2
print(dfs(k))
