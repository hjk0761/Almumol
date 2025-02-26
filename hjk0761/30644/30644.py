import sys

n = int(input())
belt = list(map(int, sys.stdin.readline().strip().split()))
sorted = sorted(belt)

valueToIndex = dict(zip(sorted, [i for i in range(n)]))

count = 0
prev = 0

for i in range(n-1):
    if prev == 0:
        if belt[i] < belt[i+1]:
            if valueToIndex[belt[i]] + 1 == valueToIndex[belt[i+1]]:
                prev = 1
            else:
                count += 1
        else:
            if valueToIndex[belt[i]] - 1 == valueToIndex[belt[i+1]]:
                prev = 2
            else:
                count += 1
    elif prev == 1:
        if belt[i] < belt[i+1] and valueToIndex[belt[i]] + 1 == valueToIndex[belt[i+1]]:
            continue
        else:
            prev = 0
            count += 1
    else:
        if belt[i] > belt[i+1] and valueToIndex[belt[i]] - 1 == valueToIndex[belt[i+1]]:
            continue
        else:
            prev = 0
            count += 1

print(count)
