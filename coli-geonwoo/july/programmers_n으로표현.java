import java.util.*;

class Solution {

    static Map<Integer, List<Integer>> map = new HashMap<>();

    public int solution(int N, int number) {
        int answer = -1;
        map.put(0, new ArrayList<>());
        for(int i=1; i<9; i++) {
            map.putIfAbsent(i, new ArrayList<>());
            int k = Integer.parseInt("1".repeat(i)) *N;
            map.get(i).add(k);

            for(int j=1; j<i; j++) {
                List<Integer> c1 = map.get(j);
                List<Integer> c2 = map.get(i-j);

                for(int a1 : c1) {
                    for(int a2: c2) {
                        int plus = a1+a2;
                        map.get(i).add(plus);

                        int minus = a1-a2;
                        if(minus>=0){
                            map.get(i).add(minus);
                        }

                        int mul = a1*a2;
                        map.get(i).add(mul);

                        if(a2!=0 && a1%a2 ==0){
                            map.get(i).add(a1/a2);
                        }
                    }
                }
            }

            if(map.get(i).contains(number)){
                return i;
            }
        }

        return -1;
    }
}
