import sys
input = sys.stdin.readline

n = int(input().strip())
k = int(input().strip())
sensor = list(map(int, input().strip().split()))
sensor.sort()
distance = [abs(sensor[i] - sensor[i+1]) for i in range(n-1)]
distance.sort()
for _ in range(min(n-1, k-1)):
    distance.pop()
print(sum(distance))
