import sys

N = int(input())
costs = [list(map(int, sys.stdin.readline().split())) for _ in range(N)]

'''
dp[i][0] : 0~i 번 집을 색칠할 때, i 번 집이 빨강색일 때의 최소 비용 값
dp[i][1] : 0~i 번 집을 색칠할 때, i 번 집이 초록색일 때의 최소 비용 값
dp[i][2] : 0~i 번 집을 색칠할 때, i 번 집이 파랑색일 때의 최소 비용 값

dp[i][0] = min(dp[i-1][1], dp[i-1][2]) + costs[i][0]
dp[i][1] = min(dp[i-1][0], dp[i-1][2]) + costs[i][1]
dp[i][2] = min(dp[i-1][0], dp[i-1][1]) + costs[i][2]

3 번 돌면서 0번 집이 각각 r, g, b 일 때의 최소값을 구하자.
'''
answer = sys.maxsize

for start_color in range(3):
    dp = [[10_000_000] * 3 for _ in range(N)]

    dp[0][start_color] = costs[0][start_color]

    for i in range(1, N-1):
        dp[i][0] = min(dp[i - 1][1], dp[i - 1][2]) + costs[i][0]
        dp[i][1] = min(dp[i - 1][0], dp[i - 1][2]) + costs[i][1]
        dp[i][2] = min(dp[i - 1][0], dp[i - 1][1]) + costs[i][2]

    for color in range(3):
        if color == start_color:
            continue
        min_cost = sys.maxsize
        for prev_color in range(3):
            if prev_color == color:
                continue
            min_cost = min(min_cost, dp[N-2][prev_color])
        dp[N-1][color] = min_cost + costs[N-1][color]

    answer = min(answer, min(dp[N-1]))

print(answer)
