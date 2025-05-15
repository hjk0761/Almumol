#include <vector>
#include <algorithm>
using namespace std;

int n2;
vector<int> times2;

bool available(long long time) {
    long long current = 0;
    for (int i = 0; i < times2.size(); i++) {
        current += time / times2[i];
        if (current >= n2) {
            return true;
        }
    }
    return false;
}

long long solution(int n, vector<int> times) {
    n2 = n;
    sort(times.begin(), times.end());
    times2 = times;
    long long answer = 0;

    long long lower = 1;
    long long upper = (long long) n * times[times.size() - 1];
    while(lower <= upper) {
        long long middle = (lower + upper + 1) / 2;
        if (available(middle)) {
            answer = middle;
            upper = middle - 1;
        } else {
            lower = middle + 1;
        }
    }

    return answer;
}
