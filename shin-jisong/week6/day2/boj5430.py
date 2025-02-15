import sys

t = int(sys.stdin.readline())
error = False
reverse_flag = False

for _ in range(t):
    p = sys.stdin.readline()
    n = int(sys.stdin.readline())
    arr_input = sys.stdin.readline().strip()
    if arr_input == "[]":
        arr = []
    else:
        arr = list(map(int, arr_input[1:-1].split(",")))

    error = False
    reverse_flag = False
    for i in p:
        if i == "R":
            if reverse_flag:
                reverse_flag = False
            else:
                reverse_flag = True
        elif i == "D":
            if len(arr) < 1:
                error = True
                break
            else:
                if reverse_flag:
                    arr.pop(-1)
                else:
                    arr.pop(0)
    if error:
        print("error")
    else:
        if reverse_flag:
            arr.reverse()
        print("[", end="")
        print(*arr, sep=",", end="")
        print("]")
      
