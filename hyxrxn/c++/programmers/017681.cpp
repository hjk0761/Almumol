#include <string>
#include <vector>
using namespace std;

vector<string> solution(int n, vector<int> arr1, vector<int> arr2) {
    vector<string> answer;

    int number;
    string str(n, ' ');
    for (int i = 0; i < n; i++) {
        number = arr1[i] | arr2[i];
        for (int j = 0; j < n; j++) {
            if (number % 2 == 1) {
                str[n - 1 - j] = '#';
            } else {
                str[n - 1 - j] = ' ';
            }
            number /= 2;
        }
        answer.push_back(str);
    }

    return answer;
}
