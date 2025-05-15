#include <string>
using namespace std;

string makeNumber(int number, int n) {
    string answer = "";
    while(number / n != 0) {
        int current = number % n;
        if (current >= 10) {
            answer += char('A' + (current - 10));
        } else {
            answer += to_string(number % n);
        }
        number /= n;
    }
    int current = number % n;
    if (current >= 10) {
        answer += char('A' + (current - 10));
    } else {
        answer += to_string(number % n);
    }

    for (int i = 0; i < answer.length() / 2; i++) {
        char dummy = answer[i];
        answer[i] = answer[answer.length() - 1 - i];
        answer[answer.length() - 1 - i] = dummy;
    }
    return answer;
}

string solution(int n, int t, int m, int p) {
    string fullText = "0";
    int current = 1;
    while(fullText.length() < m * t) {
        fullText += makeNumber(current, n);
        current++;
    }

    string answer = "";
    for (int i = 0; i < t; i++) {
        answer += fullText[p - 1 + i * m];
    }
    return answer;
}

// https://school.programmers.co.kr/learn/courses/30/lessons/17687
