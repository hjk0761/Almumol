import sys
a_i = ord('a')
c2i = dict()

for c in range(ord('a'), ord('z') + 1):
    c2i[chr(c)] = c - ord('a')

def is_in(_i, _c):
    for nxt_i, nxt_c in nxt[_i]:
        if _c == nxt_c:
            return True

    return False


def get_nxt(_i, _c):
    for nxt_i, nxt_c in nxt[_i]:
        if _c == nxt_c:
            return nxt_i

    return -1


def dfs(_i, cnt):
    if _i in chk:
        answer[0] += cnt
        cnt += 1

    nxt_set = set()
    for nxt_i, nxt_c in nxt[_i]:
        nxt_set.add(nxt_c)

    if not nxt_set:
        return

    if len(nxt_set) > 1 and _i not in chk and _i != root:
        cnt += 1

    for nxt_c in nxt_set:
        dfs(get_nxt(_i, nxt_c), cnt)


while True:
    line = sys.stdin.readline()

    if not line:
        break

    N = int(line)
    C = 10 ** 6 + 1
    root = 0
    i = 1
    nxt = [[] for _ in range(C)]
    chk = set()
    answer = [0]

    for _ in range(N):
        s = sys.stdin.readline().rstrip('\n')

        cur = root

        for c in s:
            if not is_in(cur, c):
                nxt[cur].append((i, c))
                i += 1

            cur = get_nxt(cur, c)
        chk.add(cur)

    dfs(0, 1)
    print(format(answer[0] / N, ".2f"))
