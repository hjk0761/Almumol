#include <string>
using namespace std;

int solution(string s) {
    int answer = 0;

    int i = 0;
    while(i < s.length()) {
        answer *= 10;
        if ('0' <= s[i] && s[i] <= '9') {
            answer += s[i] - '0';
            i++;
        } else if (s[i] == 'z') {
            i += 4;
        } else if (s[i] == 'o') {
            answer += 1;
            i += 3;
        } else if (s[i] == 't') {
            if (s[i + 1] == 'w') {
                answer += 2;
                i += 3;
            } else {
                answer += 3;
                i += 5;
            }
        } else if (s[i] == 'f') {
            if (s[i + 1] == 'o') {
                answer += 4;
                i += 4;
            } else {
                answer += 5;
                i += 4;
            }
        } else if (s[i] == 's') {
            if (s[i + 1] == 'i') {
                answer += 6;
                i += 3;
            } else {
                answer += 7;
                i += 5;
            }
        } else if (s[i] == 'e') {
            answer += 8;
            i += 5;
        } else {
            answer += 9;
            i += 4;
        }
    }
    return answer;
}
