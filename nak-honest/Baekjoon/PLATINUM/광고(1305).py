import sys

L = int(input())
s = sys.stdin.readline().rstrip('\n')
F = [0] * len(s)

j = 0
for i in range(1, len(s)):
    while j > 0 and s[i] != s[j]:
        j = F[j-1]

    if s[i] == s[j]:
        j += 1
        F[i] = j

x = F[L-1]
answer = L - x

# abcabca 에서 F[7] = 4 인 경우 x > L / 2 이기 때문에 정답은 바로 3이 된다.
# abcabc 에서 F[6] = 3 인 경우 x == L / 2 이기 때문에 정답은 바로 3이 된다.
if x < L / 2 and x > 0 and F[L-x-1] != 0:
    k = F[L-x-1]
    i = L - x - k - 1

    # 2 * k - 1까지 보는 이유는
    while i > 2 * k - 1:
        if F[i] != k:
            break
        i -= k

    if i == 2 * k - 1 and F[i] == k:
        answer = k
print(answer)
'''
F의 인덱스에 들어갈 때에는 1을 빼야하는 것에 주의!(헷갈릴 수 있음)

F[L-1] = x 라 하면 일단 answer = L - x 로 설정한다.

근데 만약 x >= L / 2 라면 정답은 바로 L - x 가 된다.(이때 x가 0이라면 정답은 바로 L이 된다.)
이는 문자열의 반을 넘어서 양끝이 같음을 의미한다.
abcabca 인 경우 F[7] = 4 가 되는데, 그렇다면 3글자씩 반복되는 구조임을 의미한다.
직관적으로 반을 넘어가면서 양끝이 같다면, 남은 왼쪽의 작은 부분에 대해서 반복될수 밖에 없는 구조임.

이후 F[L-1-x] = k 라 하면 F[L-1-x-k*n] = k 인지 계속 확인한다. 
언제까지? L - x - k * n 이 2 * k - 1 가 될때까지.
만약 전부 k이고, 2 * k - 1 가 될 수 있다면 정답은 k가 된다.
그게 아니라면 정답은 L - x 이다.
또한 k가 0인 경우에는 정답이 바로 L-x가 된다.

a

aa

aab

aaba

aabaa

aabaaa
'''
