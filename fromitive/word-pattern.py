""" 
title: Word Pattern
link : https://leetcode.com/problems/word-pattern/

description

문자열 pattern과 공백으로 구분된 문자열 s가 주어진다.

이때 공백으로 구분된 단어 들과 문자열의 각 문자들이 매칭이 되는지 검증하는 코드를 작성해야한다.

""" 

class Solution:
    def wordPattern(self, pattern: str, s: str) -> bool:
        # string을 split 할 때 
        words =  s.split(" ")
        if len(words) != len(pattern):
            return False
        
        patternMapper = dict()
        wordMapper = dict()
        # 패턴을 신규로 생성할 때
        for key, word in zip(pattern, words):
            # word가 이미 등록되어 있다면? - 이건 패턴메퍼에서 검증 못해
            # 1:1 대응이므로 아래의 로직 작성 가능
            if key not in patternMapper and word not in wordMapper:
                patternMapper[key] = word
                wordMapper[word] = key
            elif key in patternMapper and word in wordMapper:
                if wordMapper[word] != key or patternMapper[key] != word:
                    return False
            else: ## 둘중 하나 없는 경우
                return False

        return True