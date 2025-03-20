import sys

N = int(input())

w = list(map(int, sys.stdin.readline().split()))
w.sort()
if w[0] != 1:
    print(1)
else:
    answer = -1
    end = 1
    for i in range(1, len(w)):
        if w[i] > end + 1:
            answer = end + 1
            break
        end = end + w[i]

    if answer == -1:
        answer = end + 1

    print(answer)



'''
1 1 2 3 6 7 30

1
1 2
1 2 3 4
1 2 3 4 5 6 7
1 2 3 4 5 6 7 8 9 10 11 12 13
1 ~ 20


'''
