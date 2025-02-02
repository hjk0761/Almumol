N, a, b = map(int, input().split())

if a + b > N + 1:
    print(-1)
else:
    base = [i for i in range(1, a)] + [max(a, b)] + [i for i in range(b-1, 0, -1)]
    if base[0] == 1:
        base = [1] * (N - a - b + 1) + base
    else:
        base = [base[0]] + [1] * (N - a - b + 1) + base[1:]

    print(*base)
