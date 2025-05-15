#include <string>
#include <vector>
#include <map>

using namespace std;

vector<int> solution(string msg) {
    msg += "a";

    map<string, int> m;
    for (int i = 0; i < 26; i++) {
        string current = "";
        current += char('A' + i);
        m[current] = i + 1;
    }
    int index = 27;

    vector<int> answer;
    int start = 0;
    int end = 1;
    while(start < msg.length() - 1) {
        while(m.find(msg.substr(start, end - start)) != m.end()) {
            end++;
        }
        end--;
        answer.push_back(m[msg.substr(start, end - start)]);
        m[msg.substr(start, end + 1 - start)] = index;
        index++;

        start = end;
        end = start + 1;
    }

    return answer;
}

// https://school.programmers.co.kr/learn/courses/30/lessons/17684
