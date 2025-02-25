import sys

def init(node, s, e):
    if s == e:
        tree[node] = (nums[s], s)
        return

    init(node * 2 + 1, s, (s + e) // 2)
    init(node * 2 + 2, (s + e) // 2 + 1, e)
    tree[node] = min(tree[node * 2 + 1], tree[node * 2 + 2])

def get_min(node, s, e, l, r):
    if e < l or r < s:
        return (sys.maxsize, sys.maxsize)
    if l <= s and e <= r:
        return tree[node]

    l_min = get_min(node * 2 + 1, s, (s + e) // 2, l, r)
    r_min = get_min(node * 2 + 2, (s + e) // 2 + 1, e, l, r)
    return min(l_min, r_min)

def update(node, s, e, i, v):
    if i < s or e < i:
        return
    if s == e:
        nums[i] = (v, i)
        tree[node] = (v, i)
        return
    update(node * 2 + 1, s, (s + e) // 2, i, v)
    update(node * 2 + 2, (s + e) // 2 + 1, e, i, v)
    tree[node] = min(tree[node * 2 + 1], tree[node * 2 + 2])


N = int(input())
nums = list(map(int, sys.stdin.readline().split()))
tree = [-1] * (4 * N)
init(0, 0, N - 1)

for _ in range(int(input())):
    a, b, c = map(int, sys.stdin.readline().split())
    if a == 1:
        update(0, 0, N - 1, b - 1, c)
    else:
        print(get_min(0, 0, N - 1, b - 1, c - 1)[1] + 1)

