n = int(input())
arr = [i for i in range(1, n + 1)]

while len(arr) != 1:
    if len(arr) % 2 == 0:
        arr = [arr[i] for i in range(len(arr)) if i % 2 != 0]
    else:
        arr = [arr[-1]] + [arr[i] for i in range(len(arr)) if i % 2 != 0]
      
print(arr[0])
