import sys
input = sys.stdin.readline

n = int(input().strip())
numbers = list(map(int, input().strip().split()))

def check(numbers, a, b):
    for i in range(len(numbers)-1):
        if numbers[i+1] != numbers[i]*a + b:
            return False
    return True

def solve(n, numbers):
    if n == 1:
        return 'A'
    elif numbers[0] == numbers[1]:
        if check(numbers, 1, 0):
            return numbers[0]
        return 'B'
    elif n == 2:
        return 'A'
    a = (numbers[2] - numbers[1]) // (numbers[1] - numbers[0])
    b = numbers[1] - numbers[0]*a
    if check(numbers, a, b):
        return numbers[-1]*a + b
    return 'B'

print(solve(n, numbers))
