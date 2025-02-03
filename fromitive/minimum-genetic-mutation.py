""" 
title : Minimum Genetic Mutation
link : https://leetcode.com/problems/minimum-genetic-mutation

description

8자리의 gene string이 주어진다. 이때 gene character는 A, C, G, T중 하나로 이루어져 있다.
startGene이라는 geneString이 주어질때 endGene으로 변화하기 위한 최소 단계를 구해야 한다.
예를 들어 startGene이 AACCGGTT로 주어졌다면, 맨 끝 gene character를 한 번 변환시켜 AACCGGTA로 변환시킬 때 한 번 변화하는 것으로 간주한다.
"""

from collections import deque
class Solution:
    def minMutation(self, startGene: str, endGene: str, bank: List[str]) -> int:
        typeOfGene = ['A','C','G','T']
        geneMap = {t: i for i, t in enumerate(typeOfGene)}
        seen = set()
        seen.add(startGene)
        def nextGene(gene):
            result = []
            for i in range(len(gene)):
                for j in range(1, len(typeOfGene)):
                    nextG = typeOfGene[(geneMap[gene[i]] + j) % (len(typeOfGene))]
                    applicant = gene[:i] + nextG + gene[i + 1:]
                    if applicant in bank and applicant not in seen:
                        result.append(applicant)
            return result
        
        queue = deque()
        queue.append((startGene, 0))

        while queue:
            gene, step = queue.popleft()
            if gene == endGene:
                return step
            for nextG in nextGene(gene):
                if nextG not in seen:
                    queue.append((nextG, step + 1))
                    seen.add(nextG)
        return -1
