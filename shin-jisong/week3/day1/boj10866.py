n = int(input())
deck = []

for i in range(n):
    cmd = input()
    if cmd.startswith("push_front"):
        deck.insert(0, cmd.split()[1])
    elif cmd.startswith("push_back"):
        deck.append(cmd.split()[1])
    elif cmd == "pop_front":
        if len(deck) == 0:
            print(-1)
        else:
            print(deck.pop(0))
    elif cmd == "pop_back":
        if len(deck) == 0:
            print(-1)
        else:
            print(deck.pop(len(deck) - 1))
    elif cmd == "size":
        print(len(deck))
    elif cmd == "empty":
        if len(deck) == 0:
            print(1)
        else:
            print(0)
    elif cmd == "front":
        if len(deck) == 0:
            print(-1)
        else:
            print(deck[0])
    elif cmd == "back":
        if len(deck) == 0:
            print(-1)
        else:
            print(deck[len(deck) - 1])
