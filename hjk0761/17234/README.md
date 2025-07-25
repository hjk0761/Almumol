# Info
[Scoring Hack](https://boj.kr/17234)

- 난이도: 골드 2
- 분류: 다이나믹 프로그래밍

## 💡 풀이 방법 요약

dp 문제입니다.

저는 dp 보단 bfs 로 푼 것 같습니다.

이유는 아래에 써뒀듯이 dp로 풀었을 때에 메모리 초과가 발생해서 입니다.

문제는 결국 이기면 +a, 지면 +b, 특정 경우에 *2 의 세 경우를 가지고 n이상 n+a 이하의 점수를 낼 수 있는 턴의 수 중 최소값을 찾는 것 입니다.

따라서 bfs 로 `(score, turn, double_turn) = (0, 0, 0)` 부터 시작해서 이긴 경우, 진 경우, 두 배를 한 경우를 큐에 넣어주면서 점수가 n 이상이 되었을 떄의 차례를 반환했습니다.

## 👀 실패 이유

처음에 `dp[score] = (turn, double_turn)` 으로 두고 계산했는데 숫자가 커질수록 오차가 생겼습니다.

턴을 계산하는 부분에서 계산 실수가 있었을 것 같아 `dp[score][turn][double_turn] = True | False` 으로 두었는데, 메모리 초과가 발생했습니다.

그래서 우리가 알고싶은건 방문 여부니까 dp를 3차원으로 만드는 대신 visited 를 set 으로 선언해 방문한 상태를 저장했습니다.

## 🙂 마무리

이것저것 실험한다고 8트라이를 해버렸네요, 평균 깎아먹기 😂
