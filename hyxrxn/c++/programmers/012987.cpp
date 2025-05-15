#include <string>
#include <vector>
using namespace std;

int solution(vector<int> A, vector<int> B) {
    int answer = 0;

    sort(A.begin(), A.end());
    sort(B.begin(), B.end());

    int Ai = 0;
    int Bi = 0;

    while(Ai < A.size() && Bi < B.size()) {
        if (B[Bi] > A[Ai]) {
            answer++;
            Bi++;
            Ai++;
        } else {
            Bi++;
        }
    }

    return answer;
}
