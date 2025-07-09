import sys
def input(): return sys.stdin.readline().strip()

n, l, f = input().split()
n = int(n)
f = int(f)
l_day, l_time = l.split("/")
l_day = int(l_day)
l_hour, l_min = map(int, l_time.split(":"))
ll = l_min + 60 * l_hour + 24 * 60 * l_day

fee = dict()
book = dict()

month = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]

def get_t(date, time):
    t = 0
    _, m, d = map(int, date.split("-"))
    hh, mm = map(int, time.split(":"))
    t += mm
    t += 60 * hh
    for i in range(0, m-1):
        t += month[i] * 24 * 60
    t += (d - 1) * 24 * 60
    return t

for _ in range(n):
    date, time, part, member = input().split()
    t = get_t(date, time)
    if member not in book.keys():
        book[member] = dict()
    if part not in book[member].keys():
        book[member][part] = get_t(date, time)
    else:
        rent = book[member].pop(part)
        cost = t - rent
        if cost <= ll:
            continue
        cost -= ll
        cost *= f
        if member not in fee.keys():
            fee[member] = cost
        else:
            fee[member] += cost

members = list(fee.keys())
members.sort()

if len(members) > 0:
    for m in members:
        print(m, fee[m])
else:
    print(-1)
