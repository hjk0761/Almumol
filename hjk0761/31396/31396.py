import sys
def input(): return sys.stdin.readline().strip()

n, k, m = map(int, input().split())
a = list(map(int, input().split()))
d = list(map(int, input().split()))
a.sort(reverse=True)
d.sort()
_max = max(d)+1

def check(device):
    space = k
    a_idx = 0
    c = [0 for _ in range(max(m+1, _max))]
    for i in range(device):
        c[d[i+m-device]] += 1
    
    for i in range(m+1):
        if c[i] > space:
            return False
        space -= c[i]
        multitap = 0
        while a_idx < n and space:
            multitap += a[a_idx]
            a_idx += 1
            space -= 1
        if space == 0:
            space = multitap
            continue
        else:
            space += multitap
            for j in range(i+1, m+1):
                space -= c[j]
                if space < 0:
                    return False
            return True
    return True

def binary(left, right):
    while left + 1 < right:
        mid = (left + right) // 2
        if check(mid):
            left = mid
        else:
            right = mid
    return left

print(binary(0, m+1))
