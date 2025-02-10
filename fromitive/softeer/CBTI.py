""" 
title: CPTI
link : https://softeer.ai/app/assessment/index.html?xid=367851

description

코드런 나라에는 총 N명의 사람이 살고 있습니다. 이 나라에는 사람들의 성격을 나타내는 CPTI(CodeRun Person Type Indicator)라는 지표가 존재합니다.
CPTI는 길이 M의 이진 문자열로 표현되며, 각 자리의 값은 해당 성격 영역에 대해 그 사람이 긍정형(1)인지 부정형(0)인지를 나타냅니다. 예를 들어, 성격 영역이 세 개인 경우, 첫 번째와 세 번째 지표가 긍정형이고 두 번째 지표가 부정형이라면, 101으로 표현됩니다.
두 사람의 CPTI를 비교했을 때, 최대 두 가지 영역에서만 성격이 다르면 두 사람은 친밀감을 느낀다고 합니다. 예를 들어, M=3인 경우, CPTI가 각각 000, 101인 사람들은 성격이 다른 영역이 2개이므로 친밀감을 느낍니다. 그렇지만, CPTI가 각각 010, 101인 사람들은 세 개의 영역 모두에서 성격이 모두 다르므로, 친밀감을 느끼지 않습니다.
코드런 나라의 왕인 James는 이 나라에 살고 있는 사람들 중에서 서로 친밀감을 느끼는 사람 쌍이 얼마나 되는지 알고 싶어합니다.
James를 위해 서로 친밀감을 느끼는 사람 쌍의 수를 계산하는 프로그램을 작성하세요. 사람 쌍의 경우 순서를 고려하지 않습니다.

[문제 제약 조건]
[조건 1] 1≤N≤30,000
[조건 2] 1≤M≤30

"""
import sys
from collections import defaultdict

def solve(N, M, cptis):
    counter = defaultdict(int)
    # 중복되는 cpti 개수 담기
    for cpti in cptis:
        counter[int(cpti,2)] += 1
    
    # 중복 제거한 cpti 구하고, 중복 관계를 제거하기 위해 정렬
    unique_cptis = sorted(list(counter.keys()))
    total = 0
    for i in range(len(unique_cptis)):
        cpti1 = unique_cptis[i]
        # 같은 cpti가 존재할경우 n * (n -1) // 2 개만큼의 관계를 갖는다.
        if counter[cpti1] > 1:
            total += (counter[cpti1] * (counter[cpti1] - 1)) // 2
    
    for cpti in unique_cptis:
        count1 = counter[cpti]
        
        for i in range(M):
            cpti1 = cpti ^ (1 << i)
            ## 1개의 bit만 다른 cpti가 존재할 경우 그리고 정렬된 unique_cptis를 활용한 중복 관계 제거
            if cpti1 in counter and cpti1 > cpti:
                # 관계 개수는 기존 * bit1 차이 개수
                total += count1 * counter[cpti1]
            for j in range(i + 1, M):
                ## 2개의 bit만 다른 cpti가 존재할경우 
                cpti2 = cpti ^ (1 << i) ^ (1 << j)
                if cpti2 in counter and cpti2 > cpti:
                    total += count1 * counter[cpti2]
    return total


""" 문제 인풋
cptis = []
N, M = map(int, input().split())

for _ in range(N):
    cptis.append(input())
"""


N = 5
M = 3
cptis = [
    "001",
    "011",
    "011",
    "011",
    "011",
]

print(solve(N, M, cptis))