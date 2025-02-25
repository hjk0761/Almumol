
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long maxi = 0;
        int left = 0, right = 0;
        long sum = arr[0];
        while(true) {
            if (sum <= M) {
                maxi = Math.max(maxi, sum);
                right++;
                if (right >= N) break;
                sum += arr[right];
            } else if (sum > M) {
                sum -= arr[left];
                left++;
            }
        }
        System.out.println(maxi);
    }
}

