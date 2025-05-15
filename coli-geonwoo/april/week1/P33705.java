import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P33705 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] data = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            data[i] = Integer.parseInt(st.nextToken());
        }

        //0 -> 이미 과반 이상
        //1 -> 일렬로 나열할 때 이미 과반이상인 경우가 있을 때
        //2 -> 그런 곳이 없을 때
        int cnt1 = 0;
        int cnt2 = 0;
        boolean flag = false;
        for (int i = 0; i < n; i++) {
            int k1 = data[i];
            int k2 = data[n - 1 - i];
            if (k1 == 1) {
                cnt1++;
            }

            if (k2 == 1) {
                cnt2++;
            }

            int threshold = (int) Math.ceil((double) (i + 1) / 2);
            if (cnt1 >= threshold || cnt2 >= threshold) {
                flag = true;
            }
        }

        if (cnt1 >= Math.ceil((double) n / 2)) {
            System.out.println("0");
        } else if (flag) {
            System.out.println("1");
        } else {
            System.out.println("2");
        }
    }
}
