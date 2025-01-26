import sys

def get_F(S):
    F = [0] * len(S)
    j = 0
    for i in range(1, len(S)):
        while S[i] != S[j] and j > 0:
            j = F[j - 1]
        if S[i] == S[j]:
            j += 1
            F[i] = j

    return F

def kmp(T, S):
    F = get_F(S)
    starts = []

    j = 0
    for i in range(len(T)):
        while T[i] != S[j] and j > 0:
            j = F[j-1]
        if T[i] == S[j]:
            if j == len(S) - 1:
                starts.append(i - j + 1)
                j = F[j]
            else:
                j += 1

    return starts

t = sys.stdin.readline().rstrip('\n')
s = sys.stdin.readline().rstrip('\n')

answer = kmp(t, s)

print(len(answer))
print(*answer)
'''

ABABABADABABACABAD

ABABACABA

0012012343

ABCABCABCA
ABCABCABCD

ABCABCABC
'''
