# Info
[디저트](https://boj.kr/17953)

- 난이도: 골드 5
- 분류: 다이나믹 프로그래밍

## 💡 풀이 방법 요약

dp 문제입니다.

m이 최대 10이기 때문에 O(n * m^2)의 풀이로도 충분하겠다고 생각해서 아래 풀이를 그대로 사용했습니다.

알고싶은건 n일까지 디저트를 먹었을 때에 최대 만족감이고, 각 날짜에 알아야할건 이전에 같은 디저트를 먹었는지 입니다.

따라서 이전 날짜에서 먹은 다른 디저트 중 최대 만족감 에 오늘 이 디저트를 먹을때의 만족감을 더한 값과,

이전 날짜에서 같은 디저트를 먹었을 때의 만족감과 오늘 이 디저트를 먹을 때의 만족감의 반을 더한 값을 비교하면 됩니다.

이전 날짜에서 먹은 다른 디저트 중 최대 만족감은 단순하게 같은 디저트를 제외하고 모두 순회해서 최대값을 찾았습니다.

## 👀 실패 이유

m이 1인 경우를 고려하지 못했습니다.

이 경우 같은 디저트를 계속 먹을 수 밖에 없다는 점을 유의해야합니다.

## 🙂 마무리
