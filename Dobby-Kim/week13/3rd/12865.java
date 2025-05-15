import java.util.*;
import java.io.*;

public class Main {

    private static int n, k;
    private static Item[] items;
    private static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NK = br.readLine().split(" ");

        n = Integer.parseInt(NK[0]);
        k = Integer.parseInt(NK[1]);
        items = new Item[n];
        dp = new int[k+1];

        for(int i = 0; i < n; i++) {
            String[] WV = br.readLine().split(" ");
            items[i] = new Item(Integer.parseInt(WV[0]), Integer.parseInt(WV[1]));
        }

        for(int i = 0; i < n; i++) {
            int weight = items[i].w;
            int value = items[i].v;
            for(int j = k; j >= weight; j--) {
                dp[j] = Math.max(dp[j], dp[j - weight] + value);
            }
        }

        int result = 0;
        for(int j = 0; j <= k; j++) {
            result = Math.max(result, dp[j]);
        }
        System.out.println(result);
    }

    private static class Item {
        int w;
        int v;

        Item(int w, int v) {
            this.w = w;
            this.v = v;
        }
    }
}
