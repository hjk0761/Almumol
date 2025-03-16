#include <string>
#include <vector>
#include <unordered_map>
using namespace std;

vector<int> solution(vector<string> gems) {
    unordered_map<string, int> total;
    for (int i = 0; i < gems.size(); i++) {
        total[gems[i]]++;
    }

    int left = 0;
    int right = 0;
    int start, end;
    int length = gems.size() + 1;
    unordered_map<string, int> current;
    while(right < gems.size()) {
        current[gems[right]]++;
        right++;

        while (current.size() == total.size()) {
            if (right - left < length) {
                start = left;
                end = right;
                length = right - left;
            }

            current[gems[left]]--;
            if (current[gems[left]] == 0) {
                current.erase(gems[left]);
            }
            left++;
        }
    }

    return {start + 1, end};
}
