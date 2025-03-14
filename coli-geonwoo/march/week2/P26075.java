import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class P26075 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Deque<Integer> q1 = new ArrayDeque<>();
        Deque<Integer> q2 = new ArrayDeque<>();

        char[] s1 = br.readLine().toCharArray();
        char[] s2 = br.readLine().toCharArray();

        for (int i = 0; i < s1.length; i++) {
            if (s1[i] == '1') {
                q1.add(i);
            }

            if (s2[i] == '1') {
                q2.add(i);
            }
        }

        long cnt1 = 0;
        long cnt2 = 0;

        int oneCnt = q1.size();

        for (int i = 0; i < oneCnt; i++) {
            int position1 = q1.pollFirst();
            int position2 = q2.pollFirst();

            int diff = Math.max(position1, position2) - Math.min(position1, position2);
            cnt1 += diff / 2;
            cnt2 += diff / 2;

            if (diff % 2 != 0) {
                if (cnt1 > cnt2) {
                    cnt2++;
                } else {
                    cnt1++;
                }
            }
        }
        long answer = cnt1 * cnt1 + cnt2 * cnt2;

        System.out.println(answer);
    }
}
