import sys

sys.setrecursionlimit(100000)

answer = 0
v = set()
def dfs(amount):
    for coin in coins:
        if coins[coin] == 0:
            continue
        next_amount = amount - coin
        if next_amount == 0:
            global answer
            answer = 1
            return
        if next_amount < 0:
            continue
        if next_amount in v:
            continue
        v.add(next_amount)
        coins[coin] -= 1
        dfs(next_amount)
        coins[coin] += 1


for _ in range(3):
    v.clear()
    answer = 0
    N = int(input())

    coins = dict()
    total = 0

    for _ in range(N):
        amount, count = map(int, sys.stdin.readline().split())
        coins[amount] = count
        total += amount * count

    if total % 2 == 1:
        print(0)
    else:
        dfs(total // 2)
        print(answer)

# dp 풀이
# for _ in range(3):
#     N = int(input())
# 
#     coins = dict()
#     total = 0
# 
#     for _ in range(N):
#         amount, count = map(int, sys.stdin.readline().split())
#         coins[amount] = count
#         total += amount * count
# 
#     if total % 2 == 1:
#         print(0)
#     else:
#         dp = [True] + [False] * (total // 2 + 1)
# 
#         for coin in coins:
#             for i in range(total // 2, -1, -1):
#                 if dp[i]:
#                     for j in range(1, coins[coin] + 1):
#                         if i + coin * j > total // 2:
#                             break
#                         dp[i + coin * j] = True
# 
#         if dp[total // 2]:
#             print(1)
#         else:
#             print(0)
