import sys

def solve():
    n = int(sys.stdin.readline().strip())
    answer = []
    while n != 0:
        board = [[0 for _ in range(n)] for _ in range(n)]
        for i in range(n):
            board[i] = list(map(int, sys.stdin.readline().strip().split()))
        check = True
        for i in range(n-1):
            for j in range(n-1):
                if not ((board[i][j] - board[i][j+1] == board[i+1][j] - board[i+1][j+1]) and (board[i][j] - board[i+1][j] == board[i][j+1] - board[i+1][j+1])):
                    check = False
        if check:
            answer.append("homogeneous")
        else:
            answer.append("not homogeneous")

        n = int(sys.stdin.readline().strip())
    return answer

answer = solve()

for a in answer:
    print(a)
