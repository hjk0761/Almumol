import sys

N = int(input())
A = list(map(int, sys.stdin.readline().split()))
M = int(input())
B = list(map(int, sys.stdin.readline().split()))

answer = []
is_end = False
while not is_end:
    is_end = True
    if not A or not B:
        break
    for num in range(max(max(A), max(B)), 0, -1):
        A_i = -1
        B_i = -1
        for i in range(len(A)):
            if A[i] == num:
                A_i = i
                break
        for i in range(len(B)):
            if B[i] == num:
                B_i = i
                break

        if A_i != -1 and B_i != -1:
            answer.append(num)
            A = A[A_i + 1:]
            B = B[B_i + 1:]
            is_end = False
            break

print(len(answer))
if answer:
    print(*answer)

'''
0
4 4 35 3 53 2 34 23 32 42
0
35 35 23 35 23 42 53 2
'''
