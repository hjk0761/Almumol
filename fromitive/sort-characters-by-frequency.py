"""
title: Sort Characters By Frequency
link : https://leetcode.com/problems/sort-characters-by-frequency

description

문자열 s 에서 빈도수의 내림차순으로 정렬된 문자열을 반환한다.

해결 방안
- O(Nlog(N))
문자를 빈도수 순으로 내림차순 정렬한 후 합친다.

- O(N)
문자열 빈도수를 기반으로 한 bucket sort를 할 수 있다. 
"""

from collections import Counter
class Solution:
    def frequencySort(self, s: str) -> str:
        #O(N * log(N))
        counter = Counter(s)
        pairArray = []
        for ch in counter:
            pairArray.append((counter[ch],ch))
        pairArray.sort(reverse=True)
        answer = ""
        for count, ch in pairArray:
            answer += ch * count
        return answer
    from collections import Counter, defaultdict
    
    def frequencySort(self, s: str) -> str:
        #O(N)
        counter = Counter(s)
        maxFrequency = max(counter.values())
        bucket = [[] for _ in range(maxFrequency + 1)]
        for c, i in counter.items():
            bucket[i].append(c * i)
        
        answer = []
        for i in range(len(bucket) - 1, -1, -1):
            answer.append("".join(bucket[i]))
        
        return "".join(answer)