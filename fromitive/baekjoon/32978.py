N = int(input())
R = set(map(str, input().split()))
S = set(map(str, input().split()))
result = R - S
print(result)