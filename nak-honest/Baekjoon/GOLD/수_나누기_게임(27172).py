import sys

N = int(input())
cards = list(map(int, sys.stdin.readline().split()))
score = [0] * N
ind = {cards[i]: i for i in range(N)}

for card in sorted(cards):
    for j in range(2, 1_000_001):
        if card * j > 1_000_000:
            break

        if card * j not in ind:
            continue

        score[ind[card]] += 1
        score[ind[card * j]] -= 1

print(*score)


