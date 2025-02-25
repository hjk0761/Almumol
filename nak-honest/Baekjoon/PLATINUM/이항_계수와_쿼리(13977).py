import sys

P = 1_000_000_007

fact = [1] * 4_000_001

for i in range(1, 4_000_001):
    fact[i] = (fact[i - 1] * i) % P

for _ in range(int(input())):
    N, K = map(int, sys.stdin.readline().split())
    print((fact[N] * pow(fact[K] * fact[N - K], P - 2, P)) % P)
