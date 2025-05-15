#include <iostream>
using namespace std;

struct node {
    char data;
    node* left;
    node* right;
};
node arr[26];

int n;
char d, l, r;

void rootLeftRight(node root) {
    cout << root.data;
    if (root.left != nullptr) {
        rootLeftRight(*root.left);
    }
    if (root.right != nullptr) {
        rootLeftRight(*root.right);
    }
}

void leftRootRight(node root) {
    if (root.left != nullptr) {
        leftRootRight(*root.left);
    }
    cout << root.data;
    if (root.right != nullptr) {
        leftRootRight(*root.right);
    }
}

void leftRightRoot(node root) {
    if (root.left != nullptr) {
        leftRightRoot(*root.left);
    }
    if (root.right != nullptr) {
        leftRightRoot(*root.right);
    }
    cout << root.data;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);

    cin >> n;
    for (int i = 0; i < n; i++) {
        cin >> d >> l >> r;
        if (l != '.') {
            arr[d - 'A'].left = &arr[l - 'A'];
        } else {
            arr[d - 'A'].left = nullptr;
        }
        if (r != '.') {
            arr[d - 'A'].right = &arr[r - 'A'];
        } else {
            arr[d - 'A'].right = nullptr;
        }
        arr[i].data = i + 'A';
    }

    rootLeftRight(arr[0]);
    cout << "\n";
    leftRootRight(arr[0]);
    cout << "\n";
    leftRightRoot(arr[0]);

    return 0;
}

// https://www.acmicpc.net/problem/1991

// 데이터가 알파벳으로 이루어져 있어 이를 숫자로 표현해 노드의 배열로 사용했다. 배열의 0번째 원소는 A, 1번째 원소는 B, ... 를 표현한다.
// 입력받은 데이터로 각 배열의 원소를 찾아 왼쪽과 오른쪽의 주소를 연결한다.
// 재귀를 이용해 원하는 순서대로 탐색하며 출력한다.
