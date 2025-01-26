#include <iostream>
using namespace std;

int blue = 0;
int white = 0;
int n;
int arr[128][128];

void check(int x, int y, int size) {
    if (size == 0) return;

    bool bf = true;
    bool wf = true;

    for (int i = x; i < x + size; i++) {
        for (int j = y; j < y + size; j++) {
            if (arr[i][j] == 1) wf = false;
            if (arr[i][j] == 0) bf = false;
        }
    }

    if (wf) white++;
    else if (bf) blue++;
    else {
        int newSize = size / 2;
        check(x, y, newSize);
        check(x, y + newSize, newSize);
        check(x + newSize, y, newSize);
        check(x + newSize, y + newSize, newSize);
    }
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    cin >> n;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            cin >> arr[i][j];
        }
    }
    check(0, 0, n);

    cout << white << "\n" << blue;
    return 0;
}

// https://www.acmicpc.net/problem/2630

// 확인해야 하는 정사각형의 시작 위치와 한 변의 길이를 받아 그 정사각형이 흰색(0) 혹은 파란색(1)으로 가득 채워져있는지 확인한다.
// 하나라도 가득 차있으면 해당 사각형의 개수를 하나 늘리고, 아니라면 한 변의 길이를 반으로 줄여 네 부분의 사각형에 대해 반복한다.
// 이때 한 변의 길이가 0이 되면 함수를 바로 종료한다.
// 전체 사각형에 대해 해당 함수를 부른다.
