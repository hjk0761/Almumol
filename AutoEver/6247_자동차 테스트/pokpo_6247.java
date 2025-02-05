import java.io.*;
import java.util.*;

public class Main {
    static int[] cars;

    static int binarySearch(int left, int right, int target) {
        int ans = -1;
        while(left <= right) {
            int mid = (left + right) / 2;
            if (cars[mid] < target) {
                left = mid + 1;
            } else if (cars[mid] > target) {
                right = mid - 1;
            } else if (cars[mid] == target) {
                ans = mid;
                break;
            }
        }
        return ans;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        cars = new int[N];
        int[] query = new int[Q];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            cars[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 0; i < Q; i++) {
            query[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(cars);

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < Q; i++) {
            long pos = binarySearch(0, N - 1, query[i]);
            if (pos == -1) {
                sb.append(0);
            } else {
                long result = pos * (N - 1 - pos);
                sb.append(result);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}

