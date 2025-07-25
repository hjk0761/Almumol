# Info
[숫자](https://boj.kr/1131)

- 난이도: 플래 5
- 분류: 다이나믹 프로그래밍, 그래프 이론, 그래프 탐색, 깊이 우선 탐색

## 💡 풀이 방법 요약

dp 문제입니다.

a부터 b까지의 숫자 i에 대해서 수열 S를 만들고, 해당 수열에서 사이클이 생길 때까지 값을 탐색하면서 해당 수열에서의 최소값을 찾는 문제입니다.

논리 자체는 간단합니다.

만들어진 수열을 순회하면서, i번째 값에 대해서 i 이상의 값들 중 가장 작은 값을 찾으면 됩니다.

이렇게 풀어서 5번 예제를 통과하지 못했는데, 그 이유는 S_i -> S_(i+1) -> ... -> S_j -> S_i 로 구성되는 사이클이 존재할 때에, i <= t < j 인 t 에 대해서 S_t가 해당 수열의 최소값인 경우, S_i 부터 S_t 까지는 최소값이 S_t로 구해지지만, S_(t+1)부터 S_j까지는 최소값이 S_t보다 크게 됩니다(해당 좌표부터 이후의 죄표 중 최소값이 됨).

이때문에 나중에 S_(t+1) 부터 S_j 사이의 값을 탐색의 시작점으로 계산하는 경우 최소값보다 더 큰 값을 반환하게 됩니다.

따라서 사이클이 감지된 경우, 먼저 값을 원래대로 계산한 후, 사이클을 따라 최소값으로 다시 최적화를 시켜줘야 합니다.

## 👀 실패 이유

첫 제출 시 노드 방문 시 사이클이 발견되면 이미 계산된 사이클이어도 무조건 그 사이클을 순회했습니다.

이 때문에 시간초과가 발생했습니다.

## 🙂 마무리

푸는 데에 정말 오래 걸렸네요
