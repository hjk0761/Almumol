# Info
[비 단조성](https://boj.kr/4237)

- 난이도: 골드 4
- 분류: 그리디 알고리즘, 애드 혹

## 💡 풀이 방법 요약

앞에서부터 순회하면서 조건을 만족하는 가장 긴 길이의 수열을 찾으면 되는데, 그리디로 접근할 수 있다는 확신이 필요한 문제입니다.

여러 조건들이 먼저 그리디한 풀이가 가능함을 보증해 주는데, A 의 모든 원소가 같지 않다는 점도 포함됩니다.

예를 들어 특정 위치 i 에서의 비교 (B[1] < B[2]) 를 확인할 때에 A[i] 과 A[i+1] 을 비교해서 조건에 맞는다면 길이를 1 증가시키고 이어 다음 조건으로 다음 원소를 비교하면 됩니다.

만약 조건에 맞지 않는다면, 예시의 상황에서 A[i] > A[i+1] 이라면 기존에 선택된 부분 수열에서 마지막 원소(A[i]) 를 선택하는 것 보다 A[i+1] 를 선택하는 것이

이후 선택에서 이점이 됩니다.

왜냐하면 값이 겹치지 않는다는 조건 아래에서 다음 조건에 만족하는 원소를 찾을 수 있는 범위가 넓어지기 때문입니다.

따라서 이 경우 길이를 증가시키지 않되, 마지막으로 확인한 원소만 갱신해주면 됩니다.

## 👀 실패 이유

## 🙂 마무리

재밌는 문제였네용 ㅎ.ㅎ
