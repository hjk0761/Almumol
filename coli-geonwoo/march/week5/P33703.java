import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P33703 {

    public static void main(String[] args) throws IOException {
        //하노이 탑
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        //n개를 특정 끝자리로 옮기는 문제 -> n-1 +1번이 필요함
        long result = n*(n+1)/2;
        System.out.println(result);
    }
}
