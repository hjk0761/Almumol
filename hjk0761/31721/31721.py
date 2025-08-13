import sys
def input(): return sys.stdin.readline().strip()

n, m = map(int, input().split())
result = 0
left = []
for _ in range(n):
    a, b = map(int, input().split())
    if a >= b:
        result += 1
    else:
        left.append(a)

left.sort(reverse=True)
def step():
    global result
    if not left:
        return
    if left:
        left.pop()
        result += 1
    temp = m-1
    while left:
        if temp == 0:
            break
        if temp >= left[-1]:
            temp -= left[-1]
            left.pop()
        else:
            if len(left) > 1:
                left[-2] -= temp
            else:
                left[-1] -= temp
            break

while left:
    step()

print(result)
