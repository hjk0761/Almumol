import sys

def solution(S):
    answer = 0
    S_counter = 0
    N_counter = 0
    prev = ""
    for c in S:
        if c == 'N':
            if c != prev:
                N_counter = 0
            N_counter += 1
        if c == 'S':
            if c != prev:
                S_counter = 0
            S_counter += 1
        if N_counter < S_counter:
            answer = max(answer, N_counter)
        else:
            answer = max(answer, S_counter)
        prev = c
    print(answer*2)

N = int(input())
S = input()
solution(S)

