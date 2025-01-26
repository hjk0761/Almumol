import sys

n, m = map(int, input().split())

truth_input = list(map(int, sys.stdin.readline().strip().split()))
know = set()
for i in range(1, len(truth_input)):
    know.add(truth_input[i])

truthful = [False for _ in range(m)]
party = []

for _ in range(m):
    party_input = list(map(int, sys.stdin.readline().strip().split()))
    party.append(party_input[1:])

def check():
    for i in range(m):
        p = party[i]
        for k in know:
            if k in p:
                know.update(p)
                truthful[i] = True
                break

prev_truthful = truthful[:]
check()
while prev_truthful != truthful:
    prev_truthful = truthful[:]
    check()
    
count = 0
for t in truthful:
    if not t:
        count += 1

print(count)
