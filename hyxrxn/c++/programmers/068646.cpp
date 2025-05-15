#include <vector>
using namespace std;

int solution(vector<int> a) {
    int length = a.size();

    vector<int> leftMin(length, 0);
    leftMin[0] = a[0];
    for (int i = 1; i < length; i++) {
        leftMin[i] = min(a[i], leftMin[i - 1]);
    }

    vector<int> rightMin(length, 0);
    rightMin[length - 1] = a[length - 1];
    for (int i = length - 2; i >= 0; i--) {
        rightMin[i] = min(a[i], rightMin[i + 1]);
    }

    int answer = length;
    for (int i = 1; i < length - 1; i++) {
        if (leftMin[i - 1] < a[i] && a[i] > rightMin[i + 1]) {
            answer--;
        }
    }

    return answer;
}
