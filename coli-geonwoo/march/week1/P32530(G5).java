import java.time.Duration;
import java.time.LocalTime;
import java.util.*;
import java.io.*;

public class P32530 {
    static int n;
    static int count=0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        List<LocalTime> times = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String time = br.readLine();
            times.add(LocalTime.parse(time));
        }

        Collections.sort(times);

        int taxiCnt =0;
        LocalTime last = times.get(0).plusMinutes(10);

        for (LocalTime time : times) {
            if(taxiCnt==0){
                taxiCnt++;
                count++;
                last = rideTime(time);
                continue;
            }

            //택시 탑승
            if(taxiCnt <3 && Math.abs(Duration.between(last, time).toMinutes()) <=10){
                taxiCnt = (taxiCnt +1)%3;
            } else {
                //새로운 택시 탑승
                taxiCnt =1;
                count++;
                last = rideTime(time);
            }
        }

        bw.flush();
        bw.close();
    }

    private static LocalTime rideTime(LocalTime time) {
        //다음날로 넘어가지 않게 주의
        LocalTime lastTime  = LocalTime.parse("23:59");
        LocalTime nextTime = time.plusMinutes(10);

        if(time.isAfter(nextTime)) {
            return lastTime;
        }
        return nextTime;
    }
}
