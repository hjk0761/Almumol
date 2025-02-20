import sys
from bisect import bisect_left

N, M, L, K = map(int, input().split())
stars = sorted([tuple(map(int, sys.stdin.readline().split())) for _ in range(K)])

answer = K

for i in range(len(stars)):
    start_x = stars[i][0]

    j = i
    ys = []
    while j < len(stars) and start_x + L >= stars[j][0]:
        ys.append(stars[j][1])
        j += 1

    ys.sort()

    for j in range(len(ys)):
        start_y = ys[j]
        count = 0

        k = j

        while k < len(ys) and start_y + L >= ys[k]:
            count += 1
            k += 1

        answer = min(answer, K - count)


print(answer)
