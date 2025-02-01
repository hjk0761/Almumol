import sys

line = sys.stdin.readline().strip()
piece = {}
line_count = 1
ans = 0
is_pass = False
cut = 0

for i in range(len(line)):
    if is_pass:
        is_pass = False
        continue
      
    if line[i] == '(':
        if line[i + 1] == ')':
            cut += 1
            is_pass = True
        else:
            piece[line_count] = cut
            line_count += 1
    else:
        key, value = piece.popitem()
        ans += (cut - value + 1)
      
print(ans)
