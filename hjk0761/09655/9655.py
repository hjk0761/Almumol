n = int(input())

dp = [0 for _ in range(n+1)]

if n == 1 or n == 3:
    print('SK')
elif n == 2:
    print('CY')
else:
    dp[2] = 1

    for i in range(4, n+1):
        if dp[i-1] == dp[i-3] and dp[i-1] == 0:
            dp[i] = 1

    print('CY') if dp[n] == 1 else print('SK')
