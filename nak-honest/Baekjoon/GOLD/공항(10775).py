import sys

def can_doking(k):
    # k개
    sorted_g = sorted(g[:k])
    for i in range(k):
        if sorted_g[i] <= i:
            return False

    return True

G = int(input())
P = int(input())

g = [int(sys.stdin.readline()) for _ in range(P)]

answer = 0
diff = P // 2

while diff > 1:
    if answer + diff <= P and can_doking(answer + diff):
        answer += diff

    diff //= 2

while answer + 1 <= P and can_doking(answer + 1):
    answer += 1

print(answer)


'''
2 : 1~2
2 : 1~2
3 : 1~3
'''
