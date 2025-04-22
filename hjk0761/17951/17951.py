import sys
input = sys.stdin.readline

n, k = map(int, input().strip().split())
sheet = list(map(int, input().strip().split()))

def check(_min):
    count = 0
    temp = 0
    for s in sheet:
        temp += s
        if temp >= _min:
            temp = 0
            count += 1
    return count >= k

def binary_search():
    s, e = 0, 2000001
    while s <= e:
        mid = (s + e) // 2
        if check(mid):
            s = mid + 1
        else:
            e = mid - 1
    return (s + e) // 2

print(binary_search())
