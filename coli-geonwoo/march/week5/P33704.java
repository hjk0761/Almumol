import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P33704 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //2개일 때 -> 증가하는 부분이 있으면 끝
        //3개일 때 -> 3번 연속 감소하면 끝

        int n = Integer.parseInt(br.readLine());
        int [] data = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            data[i] = Integer.parseInt(st.nextToken());
        }
        boolean flag = false;
        for (int i = 1; i < n; i++) {
            if(data[i] >= data[i-1]){
                flag = true;
                break;
            }

            if(i-2 >=0 && data[i-1]- data[i-2] <=0 && data[i] - data[i-1] <=0){
                flag = true;
                break;
            }
        }

        if(flag){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
    }
}
