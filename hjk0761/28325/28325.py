import sys

n = int(input())

anthill = list(map(int, sys.stdin.readline().strip().split()))

hallway = [[0 for _ in range(n)] for _ in range(2)]
sideway = [[0 for _ in range(n)] for _ in range(2)]

hallway[0][0] = 0
hallway[1][0] = anthill[0]

for i in range(1, n):
    hallway[0][i] = hallway[1][i-1] + 1
    hallway[1][i] = max(hallway[0][i-1], hallway[1][i-1]) + anthill[i]

sideway[0][0] = 1
sideway[1][0] = 0
sideway[0][1] = 0
sideway[1][1] = sideway[0][0] + anthill[1]

for i in range(2, n-1):
    sideway[0][i] = sideway[1][i-1] + 1
    sideway[1][i] = max(sideway[0][i-1], sideway[1][i-1]) + anthill[i]

sideway[0][n-1] = sideway[1][n-2]
sideway[1][n-1] = max(sideway[0][n-2], sideway[1][n-2]) + anthill[n-1]

print(max(hallway[0][-1], hallway[1][-1], sideway[0][-1], sideway[1][-1]))
