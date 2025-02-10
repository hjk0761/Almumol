"""
title: GPT식 숫자 비교
link : https://softeer.ai/practice/11001

description
얼마 전 GPT의 실수 비교 방식이 화제가 된 적이 있었다.

질문) "3.9와 3.11 중에 뭐가 더 커?" / 답변) "3.11이 더 큽니다."

수학 시간에 졸지 않은 사람들은 3.9가 3.11보다 크다고 생각하지만, GPT의 눈으로 보면 Python 3.9와 Python 3.11 중 후자를 더 크게 보는 학습 데이터가 많아 저렇게 생각할 수 있다. GPT의 세상에서 3.1은 3보다 크고, 마찬가지로 3.9는 3.2보다 크지만, 3.10은 3.2보다 큰 값으로 처리된다.

구체적으로, 소수점을 기준으로 왼쪽을 수로 읽은 값을 x, 오른쪽을 수로 읽은 값을 y라고 할 때 두 수의 비교가 다음과 같이 이루어진다:

    x값이 더 작으면 더 작은 수이다.
    x값이 같을 경우 y값이 더 작으면 더 작은 수이다.
    소수점이 없는 경우는 같은 수의 소수점이 있는 경우보다 항상 작게 취급된다. (다시 말해, GPT에게 3은 3.0보다 작다.)

N개의 수들이 주어졌을 때, 이를 GPT의 기준에 따라 비내림차순으로 정렬해보자.
""" 

import sys

def gptnum(number):
    if '.' in number:
        return [ int(n) for n in number.split('.')]
    else:
        return [ int(number), -1 ]

def solve(N, numbers):
    results = [(number, gptnum(number)) for number in numbers]
    results.sort(key = lambda p : p[1])
    return [number for number,gptnum in results]

N = int(input())
numbers = [] 
for _ in range(N):
    numbers.append(input())

results = solve(N, numbers)

for result in results:
    print(result)