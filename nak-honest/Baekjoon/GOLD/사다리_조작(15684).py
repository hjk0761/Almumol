import sys


def get_ab(i):
    return (i // (N - 1), i % (N - 1))

def climb(lines, added_lines):
    cur = [i for i in range(N)]

    for i in range(H):
        for b in lines[i]:
            cur[b], cur[b+1] = cur[b+1], cur[b]

        if i not in added_lines:
            continue
        for b in added_lines[i]:
            cur[b], cur[b + 1] = cur[b + 1], cur[b]

    for i in range(N):
        if cur[i] != i:
            return False

    return True

def is_neighbor(a, b, a2, b2):
    return a == a2 and abs(b - b2) <= 1

def is_answer_1():
    for a in range(H):
        for b in range(N - 1):
            if (a, b) in line_set:
                continue

            if (a, b - 1) in line_set or (a, b + 1) in line_set:
                continue

            added = dict()
            added[a] = [b]

            if climb(H_lines, added):
                return True

    return False

def is_answer_2():
    for i in range(H * (N - 1)):
        for j in range(i + 1, H * (N - 1)):
            a, b = get_ab(i)
            a2, b2 = get_ab(j)
            if (a, b) in line_set or (a2, b2) in line_set:
                continue

            if (a, b - 1) in line_set or (a, b + 1) in line_set or (a2, b2 - 1) in line_set or (a2, b2 + 1) in line_set:
                continue

            if is_neighbor(a, b, a2, b2):
                continue

            added = dict()
            added[a] = []
            added[a2] = []
            added[a].append(b)
            added[a2].append(b2)

            if climb(H_lines, added):
                return True

    return False

def is_answer_3():
    for i in range(H * (N - 1)):
        for j in range(i + 1, H * (N - 1)):
            for k in range(j + 1, H * (N - 1)):
                a, b = get_ab(i)
                a2, b2 = get_ab(j)
                a3, b3 = get_ab(k)

                if (a, b) in line_set or (a2, b2) in line_set or (a3, b3) in line_set:
                    continue

                if (a, b - 1) in line_set or (a, b + 1) in line_set or (a2, b2 - 1) in line_set or (
                a2, b2 + 1) in line_set or (a3, b3 - 1) in line_set or (a3, b3 + 1) in line_set:
                    continue

                if is_neighbor(a, b, a2, b2) or is_neighbor(a, b, a3, b3) or is_neighbor(a2, b2, a3, b3):
                    continue

                added = dict()
                added[a] = []
                added[a2] = []
                added[a3] = []
                added[a].append(b)
                added[a2].append(b2)
                added[a3].append(b3)

                if climb(H_lines, added):
                    return True


N, M, H = map(int, input().split())

H_lines = [[] for _ in range(H)]
line_set = set()


for _ in range(M):
    a, b = map(int, sys.stdin.readline().split())
    a -= 1
    b -= 1

    H_lines[a].append(b)
    line_set.add((a, b))

if climb(H_lines, dict()):
    print(0)

elif is_answer_1():
    print(1)

elif is_answer_2():
    print(2)
elif is_answer_3():
    print(3)
else:
    print(-1)



'''
3 2 5 1 4


'''
