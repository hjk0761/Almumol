# Info
[독특한 계산기](https://boj.kr/19591)

- 난이도: 골드 3
- 분류: 구현, 자료 구조, 문자열, 파싱, 덱

## 💡 풀이 방법 요약

덱을 사용한 간단한 구현문제입니다.

사실 덱보다 문자열 파싱이 더 중요해보이고, 파싱만 잘 했다면 투포인터와 같은 방식으로도 구현할 수 있습니다.

먼저 수식을 기호로 파싱하고, 기호 사이의 정수는 정수로 변환한 후 다시 문자열로 변환하여 불필요한 선행되는 0을 없앴습니다.

이후 그 값들을 덱에 넣어준 후 앞에서 3개, 뒤에서 3개씩 분리해서 계산 결과를 이용해 문제 조건을 구현했습니다.

## 👀 실패 이유

파이썬의 정수 나눗셈 연산(`//`)은 피제수를 넘지 않는 가장 작은 정수를 제수로 나누는 것 같습니다.

일례로, 3//2 == 1, (-3)//2 = -2 가 나옵니다.

하지만 문제에선 C++ 스타일의 나눗셈을 기반으로, (-3) // 2 == -1이 나와야 하므로 7퍼에서 틀렸다는 것을 알 수 있었습니다.

## 🙂 마무리
