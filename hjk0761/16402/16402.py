import sys
input = sys.stdin.readline

n, m = map(int, input().strip().split())

def parseName(name: str):
    return name.split()[2]

nameToNum = dict()
numToName = dict()

for i in range(n):
    name = parseName(input().strip())
    nameToNum[name] = i+1
    numToName[i+1] = name

parent = [i for i in range(n+1)]

def find(node):
    if parent[node] == node:
        return node
    parent[node] = find(parent[node])
    return parent[node]

def union(winner, loser):
    winner_parent, loser_parent = find(winner), find(loser)
    if winner_parent == loser_parent:
        parent[winner] = winner
        parent[loser_parent] = winner
        return
    parent[loser_parent] = winner_parent

def parseBattle(battle: str):
    parsed = battle.split(",")
    parsed[0] = parseName(parsed[0])
    parsed[1] = parseName(parsed[1])
    if parsed[2] == '1':
        return [parsed[0], parsed[1]]
    else:
        return [parsed[1], parsed[0]]

battle = []
for i in range(m):
    battle.append(parseBattle(input().strip()))

for winner, loser in battle:
    union(nameToNum[winner], nameToNum[loser])

result = []

for i in range(1, n+1):
    if parent[i] == i:
        result.append(numToName[i])

result.sort()

def nameToFull(name):
    return "Kingdom of " + name

print(len(result))
for re in result:
    print(nameToFull(re))
