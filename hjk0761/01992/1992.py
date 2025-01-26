import sys

n = int(input())
image = [[0 for _ in range(n)] for _ in range(n)]

for i in range(n):
    image[i] = list(sys.stdin.readline().strip())

def compress(s, e):
    global image
    if s == e:
        return image[s[0]][s[1]]
    else:
        dy = (s[0] + e[0]) // 2
        dx = (s[1] + e[1]) // 2
        ul = compress(s, [dy, dx])
        ur = compress([s[0], dx+1], [dy, e[1]])
        dl = compress([dy+1, s[1]], [e[0], dx])
        dr = compress([dy+1, dx+1], e)
        if ul == ur and ur == dl and dl == dr and len(ul) == 1:
            return ul
        return '(' + ul + ur + dl + dr + ')'
    
print(compress([0, 0], [n-1, n-1]))
