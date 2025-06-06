import sys
from collections import deque
def input(): return sys.stdin.readline().strip()

equation = input()
equation = equation.replace("+", " + ")
equation = equation.replace("*", " * ")
equation = equation.replace("-", " - ")
equation = equation.replace("/", " / ")
tokens = equation.split(" ")
tokens = [str(int(token)) if token.isdigit() else token for token in tokens]

def cal(left, symbol, right):
    if symbol == "+":
        return int(left) + int(right)
    elif symbol == "*":
        return int(left) * int(right)
    elif symbol == "-":
        return int(left) - int(right)
    else:
        return abs(int(left))//abs(int(right)) * (-1 if ((int(left) > 0) ^ (int(right) > 0)) else 1)

q = deque(tokens)
temp = q.popleft()
if temp == "":
    q.popleft()
    q.appendleft(str(-1 * int(q.popleft())))
else:
    q.appendleft(temp)

while len(q) > 3:
    final = False
    if len(q) == 5:
        final = True
    first_left, first_symbol, first_right = q.popleft(), q.popleft(), q.popleft()
    last_right, last_symbol, last_left = q.pop(), q.pop(), q.pop() if q else first_right
    first = cal(first_left, first_symbol, first_right)
    last = cal(last_left, last_symbol, last_right)
    if first_symbol in ["*", "/"] and last_symbol in ["+", "-"]:
        q.appendleft(first)
        if not final:
            q.append(last_left)
        q.append(last_symbol)
        q.append(last_right)
    elif last_symbol in ["*", "/"] and first_symbol in ["+", "-"]:
        q.append(last)
        if not final:
            q.appendleft(first_right)
        q.appendleft(first_symbol)
        q.appendleft(first_left)
    elif first >= last:
        q.appendleft(first)
        if not final:
            q.append(last_left)
        q.append(last_symbol)
        q.append(last_right)
    else:
        q.append(last)
        if not final:
            q.appendleft(first_right)
        q.appendleft(first_symbol)
        q.appendleft(first_left)
if len(q) == 3:
    print(cal(q.popleft(), q.popleft(), q.popleft()))
else:
    print(q.pop())
