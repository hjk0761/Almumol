import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class P17208 {
    static int [][][] dp; //몇 번째, 치즈버거, 감자튀김
    static List<Order> orders = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int chess = Integer.parseInt(st.nextToken());
        int potato = Integer.parseInt(st.nextToken());
        dp = new int[n+1][chess+1][potato+1];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int burger = Integer.parseInt(st.nextToken());
            int fries = Integer.parseInt(st.nextToken());
            orders.add(new Order(burger, fries));
        }

        for (int i = 0; i < n; i++) {
            Order order = orders.get(i);
            for (int j = 0; j <= chess; j++) {
                for (int k = 0; k <= potato; k++) {
                    if(j==0 || k ==0){
                        continue;
                    }

                    if(order.chess > j || order.potato >k){
                        dp[i+1][j][k] = dp[i][j][k];
                        continue;
                    }
                    dp[i+1][j][k] = Math.max(dp[i][j][k], dp[i][j-order.chess][k-order.potato]+1);
                }
            }
        }

        System.out.println(dp[n][chess][potato]);
    }

    static class Order {
        int chess;
        int potato;

        public Order(int chess, int potato) {
            this.chess = chess;
            this.potato = potato;
        }
    }
}
