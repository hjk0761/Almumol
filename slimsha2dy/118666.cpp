#include <string>
#include <vector>

using namespace std;
int cnt[100];

string solution(vector<string> survey, vector<int> choices) {
    string answer = "";
    
    for (int i = 0; i < survey.size(); ++i)
        cnt[survey[i][1]] += choices[i] - 4;
    answer += (cnt['R'] >= cnt['T']) ? "R" : "T";
    answer += (cnt['F'] > cnt['C']) ? "F" : "C";
    answer += (cnt['M'] > cnt['J']) ? "M" : "J";
    answer += (cnt['A'] >= cnt['N']) ? "A" : "N";
    return answer;
}
