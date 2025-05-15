#include <vector>
#include <algorithm>
using namespace std;

int solution(int n, vector<int> money) {
    sort(money.begin(), money.end());

    vector<int> count(n + 1, 0);
    count[0] = 1;
    for (int i = 0; i < money.size(); i++) { // i번째 동전까지만 사용
        for (int j = money[i]; j <= n; j++) { // j원 만드는 경우의 수
            count[j] += count[j - money[i]];
        }
    }

    return count[n];
}
