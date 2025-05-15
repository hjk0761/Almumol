#include <string>
#include <vector>
#include <iostream>
using namespace std;

int arr[500][500] = {0};

int solution(vector<vector<int>> triangle) {
    arr[0][0] = triangle[0][0];
    for (int i = 1; i < triangle.size(); i++) {
        for (int j = 0; j <= i; j++) {
            arr[i][j] = triangle[i][j];
            if (j == 0) {
                arr[i][j] += arr[i - 1][j];
            } else if (j == i) {
                arr[i][j] += arr[i - 1][j - 1];
            } else {
                arr[i][j] += max(arr[i - 1][j - 1], arr[i - 1][j]);
            }
        }
    }

    int answer = 0;
    for (int i = 0; i < triangle.size(); i++) {
        answer = max(answer, arr[triangle.size() - 1][i]);
    }

    return answer;
}
