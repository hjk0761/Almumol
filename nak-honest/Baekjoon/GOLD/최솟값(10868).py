import sys

def init(node, start, end):
    if start == end:
        min_tree[node] = nums[start]
        return

    init(node * 2 + 1, start, (start + end) // 2)
    init(node * 2 + 2, (start + end) // 2 + 1, end)
    min_tree[node] = min(min_tree[node * 2 + 1], min_tree[node * 2 + 2])

def get_min(node, start, end, left, right):
    if end < left or right < start:
        return sys.maxsize
    if left <= start and end <= right:
        return min_tree[node]

    l_min = get_min(node * 2 + 1, start, (start + end) // 2, left, right)
    r_min = get_min(node * 2 + 2, (start + end) // 2 + 1, end, left, right)
    return min(l_min, r_min)

N, M = map(int, input().split())
nums = [int(sys.stdin.readline()) for _ in range(N)]
min_tree = [sys.maxsize] * (4 * N)
init(0, 0, N - 1)

for _ in range(M):
    a, b = map(int, sys.stdin.readline().split())
    a -= 1
    b -= 1
    print(get_min(0, 0, N - 1, a, b))
