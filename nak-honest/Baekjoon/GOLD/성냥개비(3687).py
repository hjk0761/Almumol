import sys

zero = 6

num_count = [-1, -1, 1, 7, 4, 2, 0, 8]

def find_max(n):
    if n % 2 == 0:
        return '1' * (n // 2)
    else:
        return '7' + '1' * (n // 2 - 1)

'''
자리수가 많을수록 무조건 큰수가 된다. -> 성냥이 짝수개인 경우에는 1로만 채우고, 홀수개인 경우에는 7 1개와 나머지는 1로 채운다.
자리수가 작을수록 무조건 작은수가 된다.
2 ~ 7 인 경우 -> 한자리수
8 ~ 14 인 경우 -> 두자리수
15 ~ 21 인 경우 -> 세자리수 18
22 ~ 28
즉 7 * kn 보다 작거나 같은 경우 -> k 자리수


7 7 7 5
7 7 6 6

7 7 7 7 7 2
7 7 7 7 6 3
7 7 7 7 5 4
7 7 7 6 6 4
7 7 7 6 5 5
7 7 6 6 6 5
7 6 6 6 6 6
맨 앞자리가 0인 경우, 0이 아닌 바로 다음 수가 6보다 작거나 같다면 두 수의 자리를 바꾼다.
만약 6보다 크다면 맨 앞자리를 6으로 바꾼다.

'''
answer = []
for _ in range(int(input())):
    n = int(input())

    if n == 6:
        answer.append("6 " + find_max(n))
        continue

    min_num = sys.maxsize
    counts = [7] * (n // 7)
    if n % 7 != 0:
        counts.append(n % 7)

    if len(counts) <= 1:
        answer.append(f'{num_count[n]} ' + find_max(n))
        continue

    is_end = False
    while not is_end:
        matches = []

        if counts[-1] >= 2:
            for count in counts:
                matches.append(num_count[count])

            matches.sort()

            if matches[0] == 0:
                i = 1
                while i < len(matches) and matches[i] == 0:
                    i += 1
                if i == len(matches) or matches[i] > 6:
                    matches[0] = 6
                else:
                    matches[0], matches[i] = matches[i], matches[0]

            min_num = min(min_num, int(''.join(map(str, matches))))

        i = -2
        j = 1
        while counts[i] < counts[i + j] + 2:
            if i + j == -1:
                if i == -len(counts):
                    is_end = True
                    break
                i -= 1
                j = 1
                continue
            j += 1
        if is_end:
            break

        counts[i] -= 1
        counts[i + j] += 1


    answer.append(f'{min_num} ' + find_max(n))

print(*answer, sep='\n')
