S = input()

def is_palindrome(S):
    answer = 0
    left = 0
    right = len(S) - 1
    while left < right:
        if S[left] != S[right]:
            return False
        left += 1
        right -= 1
    return True

def is_same_character(S):
    for i in range(1,len(S)):
        if S[i] != S[i - 1]:
            return False
    return True

def solve(S):
    if len(S) < 2:
        print(len(S))
        return
    if is_palindrome(S):
        if is_same_character(S):
            print(-1)
        else:
            print(len(S) - 1)
    else:
        print(len(S))

solve(S)


## better solution

S = input()

if S == S[0] * len(S):
    print(-1)
elif S == S[::-1]:
    print(len(S) - 1)
else:
    print(len(S))