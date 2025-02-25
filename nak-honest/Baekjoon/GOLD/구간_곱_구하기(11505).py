import sys

P = 1_000_000_007
def init(node, s, e):
    if s == e:
        tree[node] = nums[s]
        return
    init(node * 2 + 1, s, (s + e) // 2)
    init(node * 2 + 2, (s + e) // 2 + 1, e)
    tree[node] = (tree[node * 2 + 1] * tree[node * 2 + 2]) % P

def get(node, s, e, l, r):
    if e < l or r < s:
        return 1
    if l <= s and e <= r:
        return tree[node] % P
    l_mul = get(node * 2 + 1, s, (s + e) // 2, l, r)
    r_mul = get(node * 2 + 2, (s + e) // 2 + 1, e, l, r)
    return (l_mul * r_mul) % P

def update(node, s, e, i, v):
    if i < s or e < i:
        return
    if s == e:
        nums[i] = v
        tree[node] = v
        return

    update(node * 2 + 1, s, (s + e) // 2, i, v)
    update(node * 2 + 2, (s + e) // 2 + 1, e, i, v)
    tree[node] = (tree[node * 2 + 1] * tree[node * 2 + 2]) % P

N, M, K = map(int, input().split())

nums = [int(sys.stdin.readline()) for _ in range(N)]
tree = [1] * (4 * N)
init(0, 0, N - 1)

for _ in range(M + K):
    a, b, c = map(int, sys.stdin.readline().split())
    if a == 1:
        update(0, 0, N - 1, b - 1, c)
    else:
        print(get(0, 0, N - 1, b - 1, c - 1))


