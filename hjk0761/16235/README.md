# Info
[나무 재태크](https://boj.kr/16235)

- 난이도: 골드 3
- 분류: 구현, 자료 구조, 시뮬레이션

## 💡 풀이 방법 요약

간단한? 시뮬레이션입니다.

물론 말대로 구현하면 시간초과를 마주하게 됩니다.

각 좌표별로 살아있는 나무를 관리할 deque list 와, 각 좌표별로 남아있는 비료를 관리할 정수 list 를 사용했습니다.

나무 관리에 deque 를 사용할 수 있었던 이유는, 나무가 성장하면서 순서가 바뀌지 않기 때문에 나무를 확인할 때에 popleft, 성장한 후에 append 를 하면 됩니다.

또한 주변 나무의 성장으로 인해 새로 나무가 생겨날 때에도 무조건 나이가 1인 나무가 생기므로 appendleft 를 해주면 순서가 유지됩니다.

## 👀 실패 이유

시간초과 * 4

봄에 확인해야 하는 나무가 어린 나무부터이므로, 이를 위해 각 땅의 좌표가 minheap 인 headq 를 가지도록 구현했습니다.

python3 으로 제출하면 9퍼센트에서 시간초과가 발생하고, pypy 로 제출하면 39퍼센트에서 시간초과가 발생했습니다.

봄과 여름, 가을과 겨울이 같은 반복문 안에서 돌아갈 수 있다는 점도 중요할 것 같았습니다.

여름을 위해 죽은 나무를 모두 리스트에 저장한 후, 이를 순회하면서 더해지는 비료값을 구했는데, 이 또한 죽은 나무가 발생할 때 마다 변수에 더해준 후 반복문 없이 처리할 수 있었습니다.

## 🙂 마무리

pypy 로 제출해서 시간초과를 면했는데,

풀고나서 확인해보니 dict 를 사용하면 python3 로도 시간초과를 피할 수 있었더군요.

pypy 만 통과해서 조금 아쉽습니다.
