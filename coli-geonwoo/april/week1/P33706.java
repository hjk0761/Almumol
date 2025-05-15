import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class P33706 {
    static int n;
    static int m;
    static Map<Integer, List<Integer>> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 1; i <=n ; i++) {
            map.put(i, new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            map.get(a).add(b);
            map.get(b).add(a);
        }
        boolean flag = true;

        for (int i = 2; i <=n; i++) {
            boolean flag2 = false;
            List<Integer> nexts = map.get(i);

            for (Integer next : nexts) {
                if(next< i) {
                    flag2 = true;
                    break;
                }
            }

            if (!flag2){
                flag = false;
                break;
            }
        }

        if(flag) {
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
    }
}
