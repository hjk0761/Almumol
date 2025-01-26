k = int(input())
word = input().strip()

def shuffle(word):
    new = ""
    for i in range((len(word)+1)//2):
        new += word[i*2]
    temp = 1 if len(word) % 2 == 0 else 2
    for i in range(len(word)//2):
        new += word[len(word)-temp-i*2]
    return new

shuffled = word[:]
period = -1
count = 0

for i in range(k):
    shuffled = shuffle(shuffled)
    count += 1
    if shuffled == word:
        period = count
        break

if period != -1:
    for _ in range(k%period):
        shuffled = shuffle(shuffled)
print(shuffled)
