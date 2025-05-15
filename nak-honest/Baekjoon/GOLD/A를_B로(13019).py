import sys
from collections import Counter

def is_sub(l):
    sub = list(B[len(B) - l:len(B)])
    max_cnt = 0

    for i in range(len(A)):
        if max_cnt == len(sub):
            return True
        if A[i] == sub[max_cnt]:
            max_cnt += 1

    return max_cnt == len(sub)


A = sys.stdin.readline().rstrip('\n')
B = sys.stdin.readline().rstrip('\n')

if Counter(A) != Counter(B):
    print(-1)
else:
    diff = len(A) // 2
    cur = 0

    while diff > 1:
        if is_sub(cur + diff):
            cur += diff
        diff //= 2

    while cur + 1 <= len(A) and is_sub(cur + 1):
        cur += 1

    print(len(A) - cur)
