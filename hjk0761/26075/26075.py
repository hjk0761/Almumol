import sys

n, m = map(int, input().split())

s = input()
t = input()

left_zero_s = [0 for _ in range(n+m)]
left_zero_t = [0 for _ in range(n+m)]
left_zero_s[0] = 0 if s[0] == '1' else 1
left_zero_t[0] = 0 if t[0] == '1' else 1

for i in range(1, n+m):
    c = s[i]
    if c == '0':
        left_zero_s[i] = left_zero_s[i-1] + 1
    else:
        left_zero_s[i] = left_zero_s[i-1]
    cc = t[i]
    if cc == '0':
        left_zero_t[i] = left_zero_t[i-1] + 1
    else:
        left_zero_t[i] = left_zero_t[i-1]

s_1 = [i for i in range(n+m) if s[i] == '1']
t_1 = [i for i in range(n+m) if t[i] == '1']

result = 0
for i in range(m):
    result += abs(s_1[i] - t_1[i])

if result % 2 == 0:
    print(2*(result//2 * result//2))
else:
    print((result//2)*(result//2) + (result//2+1)*(result//2+1))
