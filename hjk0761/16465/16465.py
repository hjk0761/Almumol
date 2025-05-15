import sys
input = sys.stdin.readline

n, m, l = map(int, input().strip().split())
books = list(map(int, input().strip().split()))
total = sum(books)

if total > m:
    print(-1)
elif m == total:
    print(0)
elif l > total:
    if total + l > m:
        print(-1)
    else:
        print(1)
else:
    print(1)
