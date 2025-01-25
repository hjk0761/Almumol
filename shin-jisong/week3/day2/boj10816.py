n = int(input())
cards = list(map(int, input().split()))
m = int(input())
counts = list(map(int, input().split()))

dic = {}

for card in cards:
    if card in dic:
        dic[card] += 1
    else:
        dic[card] = 1
      
ans =[]
for count in counts:
    if count in dic:
        ans.append(dic[count])
    else:
        ans.append(0)
      
print(*ans, end=" ")
