import java.util.*;

public class 서버_증설_횟수 {
    //m명 늘어날때마다 증설, 5시간동안 운영
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int persons = 0;
        Deque<Integer> serverEnds = new ArrayDeque<>();
        int cnt=0;

        for(int i=0; i<24; i++) {
            persons =players[i];
            int serverCnt = serverEnds.size();

            if(persons >= (serverCnt+1) * m) {
                int needServer = persons/m;
                int increServer = (needServer - serverCnt);
                cnt+= increServer;
                for(int j=0; j<increServer; j++){
                    serverEnds.add(i+k-1);
                }
            }

            while(!serverEnds.isEmpty() && serverEnds.peek() == i){
                serverEnds.pollFirst();
            }
        }
        return cnt;
    }
}
