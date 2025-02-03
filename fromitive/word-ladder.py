"""  
title : Word Ladder
link  : https://leetcode.com/problems/word-ladder

beginWord로 부터 시작해서 endWord로 변환하기 까지 최소 변환 횟수를 구해야한다.

한번에 한 문자만 변경할 수 있으며, wordList에 존재하지 않은 변환은 허용하지 않는다.

즉 wordList에 endWord가 존재하지 않는다면 번환할 수 없다.

해결 방안 

각 word마다 한 번에 변환 가능한 글자를 wordList에 찾고 graph로 변환한다.

graph를 만들때 각 word마다 key로 만들게 된다면 wordList ** 2 의 시간복잡도가 발생하게 된다. 따라서 더 효율적인 방법을 찾아야 한다.

각 글자마다 wildCard를 변환하여 graph의 키로 변경한다면 다음으로 변환 가능한 단어드를 빠르게 찾을 수 있게된다.

"""

from collections import defaultdict, deque
class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        graph = defaultdict(list)
        for word in wordList:
            for i in range(len(beginWord)):
                wildCardWord = word[:i] + "*" + word[i + 1:]
                graph[wildCardWord].append(word)

        queue = deque()
        queue.append((beginWord, 1))
        seen = set()
        seen.add(beginWord)
        answer = 0
        while queue:
            word, step = queue.popleft()
            for i in range(len(word)):
                wildCardWord = word[:i] + "*" + word[i + 1:]
                for neighbor in graph[wildCardWord]:
                    if neighbor not in seen:
                        if neighbor == endWord:
                            return step + 1
                        seen.add(neighbor)
                        queue.append((neighbor, step + 1))
        return 0
