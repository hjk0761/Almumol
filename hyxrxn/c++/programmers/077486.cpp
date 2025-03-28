#include <string>
#include <vector>
#include <map>
using namespace std;

vector<int> solution(vector<string> enroll, vector<string> referral, vector<string> seller, vector<int> amount) {
    map<string, string> jojic;
    for (int i = 0; i < enroll.size(); i++) {
        jojic[enroll[i]] = referral[i];
    }

    map<string, int> sellInfo;
    for (int i = 0; i < seller.size(); i++) {
        sellInfo[seller[i]] += amount[i] * 100;
    }

    map<string, int> result;
    for (int i = 0; i < seller.size(); i++) {
        string currentP = seller[i];
        int currentM = amount[i] * 100;
        while (jojic[currentP] != "-" && currentM >= 10) {
            result[currentP] += currentM - currentM / 10;
            currentM /= 10;
            currentP = jojic[currentP];
        }
        result[currentP] += currentM - currentM / 10;
    }

    vector<int> answer;
    for (int i = 0; i < enroll.size(); i++) {
        answer.push_back(result[enroll[i]]);
    }
    return answer;
}
