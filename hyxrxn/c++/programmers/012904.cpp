#include <iostream>
#include <string>
using namespace std;

bool dp[2500][2500] = {false};

int solution(string s)
{
    int answer=0;

    for (int i = 0; i < s.length(); i++) {
        dp[i][i] = true;
        answer = 1;
    }
    for (int i = 0; i < s.length() - 1; i++) {
        if (s[i] == s[i + 1]) {
            dp[i][i + 1] = true;
            answer = 2;
        }
    }

    for (int i = 3; i <= s.length(); i++) { // 연속한 i글자
        for (int j = 0; j <= s.length() - i; j++) { // j번째 자리부터 시작하는
            if (s[j] == s[j + i - 1] && dp[j + 1][j + i - 2]) {
                dp[j][j + i - 1] = true;
                answer = i;
            }
        }
    }

    return answer;
}
