import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        int[] basket = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            basket[i] = Integer.parseInt(st.nextToken());
        }

        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += basket[i];
        }

        if (sum % k != 0) {
            System.out.println("NO");
            return;
        }

        Arrays.sort(basket);

        int left = 0;
        int right = n - 1;
        int result = 0;

        while (left < right) {
            int current = basket[left];
            basket[right] += current;
            basket[left] = 0;
            result += current;

            if (basket[right] > k) {
                int remain = basket[right] - k;
                basket[left] += remain;
                basket[right] -= remain;
                result -= remain;
            }

            if (basket[left] == 0) {
                left++;
            }

            if (basket[right] == k) {
                right--;
            }

            if (result > t) {
                System.out.println("NO");
                return;
            }
        }

        if (result <= t) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
