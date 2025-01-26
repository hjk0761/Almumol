import sys
from heapq import nsmallest

N, K = map(int, input().split())
jo = list(map(int, sys.stdin.readline().split()))
diffs = [jo[i+1] - jo[i] for i in range(N-1)]
print(sum(nsmallest(N-K, diffs)))
