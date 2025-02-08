from itertools import combinations

L, C = map(int, input().split())
chars = sorted(input().split())

mos = []
jas = []

answer = []
for c in chars:
    if c in ('a', 'e', 'i', 'o', 'u'):
        mos.append(c)
    else:
        jas.append(c)


for i in range(len(mos)):
    for j in range(len(jas)):
        for k in range(j + 1, len(jas)):
            for comb in combinations(mos[i+1:] + jas[k+1:], L-3):
                answer.append(''.join(sorted([mos[i], jas[j], jas[k]] + list(comb))))
print(*sorted(answer), sep='\n')
