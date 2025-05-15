import sys, heapq
input = sys.stdin.readline

n = int(input().strip())
sheep = list(map(lambda x: x*(-1), map(int, input().strip().split())))
heapq.heapify(sheep)
time, result = 0, 0

while True:
    next = -1 * heapq.heappop(sheep)
    if next - time <= 0:
        break
    result += next - time
    time += 1

print(result)
