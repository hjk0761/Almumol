import sys

def init(node, start, end):
    if start == end:
        tree[node] = A[start]
        return
    init(node * 2 + 1, start, (start + end) // 2)
    init(node * 2 + 2, (start + end) // 2 + 1, end)
    tree[node] = min(tree[node * 2 + 1], tree[node * 2 + 2])

def get_min(node, start, end, left, right):
    if end < left or right < start:
        return sys.maxsize
    if left <= start and end <= right:
        return tree[node]
    l_min = get_min(node * 2 + 1, start, (start + end) // 2, left, right)
    r_min = get_min(node * 2 + 2, (start + end) // 2 + 1, end, left, right)
    return min(l_min, r_min)

def update(node, start, end, index, value):
    if index < start or end < index:
        return
    if start == end:
        tree[node] = value
        A[index] = value
        return
    update(node * 2 + 1, start, (start + end) // 2, index, value)
    update(node * 2 + 2, (start + end) // 2 + 1, end, index, value)
    tree[node] = min(tree[node * 2 + 1], tree[node * 2 + 2])

N = int(input())
A = list(map(int, sys.stdin.readline().split()))
M = int(input())

tree = [sys.maxsize] * (4 * N)
init(0, 0, N - 1)

for _ in range(M):
    a, b, c = map(int, sys.stdin.readline().split())
    if a == 1:
        update(0, 0, N - 1, b - 1, c)
    else:
        print(get_min(0, 0, N - 1, b - 1, c - 1))
