import sys
def input(): return sys.stdin.readline().strip()

n = int(input())
total = 0
max_height = -1

area = dict()
for _ in range(n):
    b, h, w, d = map(int, input().split())
    total += h*w*d
    max_height = max(max_height, b+h)
    if b in area.keys():
        area[b] += w*d
    else:
        area[b] = w*d
    if b+h in area.keys():
        area[b+h] -= w*d
    else:
        area[b+h] = -w*d
water = int(input())

dp = dict()
dp[0] = 0
prev = 0
for a in sorted(area.keys()):
    dp[a] = dp[prev] + area[a]
    prev = a
if dp[0] == 0:
    dp.pop(0)

volume = dict()
volume[0] = 0
height, areas = 0, 0
for a in sorted(dp.keys()):
    volume[a] = volume[height] + (a - height) * areas
    height = a
    areas = dp[a]

target = list(sorted(volume.keys()))
def binary(left, right):
    while left+1 < right:
        mid = (left + right) // 2
        if volume[target[mid]] > water:
            right = mid
        else:
            left = mid
    return left

def find(water, cur_height, cur_volume, cur_area):
    remain = water - cur_volume
    if remain % cur_area == 0:
        return "%d.00"%(cur_height+(remain//cur_area))
    cur_height += remain//cur_area
    remain %= cur_area
    remain *= 10
    first = remain//cur_area
    if remain % cur_area == 0:
        return "%d.%d0"%(cur_height, first)
    remain %= cur_area
    remain *= 10
    second = remain//cur_area
    if remain % cur_area == 0:
        return "%d.%d%d"%(cur_height, first, second)
    remain %= cur_area
    remain *= 10
    third = remain//cur_area
    if third >= 5:
        second += 1
        if second == 10:
            second = 0
            first += 1
            if first == 10:
                first = 0
                cur_height += 1
    return "%d.%d%d"%(cur_height, first, second)

def solve():
    if water > total:
        return "OVERFLOW"
    elif water == total:
        return "%d.00"%(max_height)
    idx = binary(-1, len(target))
    hh = target[idx]
    aa = dp[hh]
    if water == volume[hh]:
        if dp[target[idx-1]] > 0:
            return "%d.00"%(hh)
        else:
            return "%d.00"%(target[idx-1])
    return find(water, hh, volume[hh], aa)

print(solve())
