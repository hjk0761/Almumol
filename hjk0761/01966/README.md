# Info
[프린터 큐](https://boj.kr/1966)

- 난이도: 실버 3
- 분류: 구현, 자료 구조, 시뮬레이션, 큐

## 💡 풀이 방법 요약

입력받은 문서를 중요도 순으로 정렬한 스택 하나와, 문서가 출력되거나 재배치되는 경우를 관리하기 위한 덱을 사용했습니다.

스택의 pop() 과 덱의 popleft(), append() 는 모두 O(1) 의 시간 복잡도를 가지기 때문에 이를 사용할 수 있었습니다.

덱의 앞에서 문서를 확인하여, 스택의 맨 끝(가장 높은 우선도)과 우선도가 같은 경우 문서를 출력합니다(덱에서 제거).

그 외의 경우 덱의 맨 끝으로 재배치하여 이를 반복 수행하였습니다.

초기 문서의 위치에 따른 결과를 알아야 하므로 덱의 구조를 (우선도, 초기 위치)로 설정하여 이를 확인했습니다.

## 👀 실패 이유

## 🙂 마무리
