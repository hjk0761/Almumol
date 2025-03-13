import sys

def minus_one(a):
    return int(a) - 1

for _ in range(int(input())):
    N = int(input())
    students = list(map(minus_one, sys.stdin.readline().split()))

    cycle_cnt = 0

    v = [False] * N
    for i in range(N):
        if v[i]:
            continue

        for_v = set()

        start = i
        cur = start

        while True:
            cur = students[cur]

            if cur not in for_v and v[cur]:
                break
            v[cur] = True

            if cur in for_v:
                s = cur
                cycle_cnt += 1
                while students[cur] != s:
                    cycle_cnt += 1
                    cur = students[cur]
                break
            for_v.add(cur)
            if cur == start:
                cycle_cnt += len(for_v)

                break

        v[cur] = True

    print(N - cycle_cnt)





'''
cycle 구하는 문제

'''
