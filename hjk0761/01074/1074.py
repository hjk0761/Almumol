n, r, c = map(int, input().split())

def find(d, y, x, by, bx):
    ny, nx = y - by, x - bx
    base = 2 ** (d-1)
    k = 0
    if ny < base:
        k = 0 if nx < base else 1
    else:
        k = 2 if nx < base else 3
    if d == 1:
        return k
    dx = 0 if k % 2 == 0 else base
    dy = 0 if k < 2 else base
    return k*(2**(2*(d-1))) + find(d-1, y, x, by+dy, bx+dx)

print(find(n, r, c, 0, 0))
