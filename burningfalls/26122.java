
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Main {

    static class Node {
        char c;
        int cnt;

        Node(char c, int cnt) {
            this.c = c;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        String s = br.readLine();

        List<Node> list = new ArrayList<>();
        int cnt = 1;
        char c = s.charAt(0);
        for(int i = 1; i < k; i++) {
            if (s.charAt(i) == c) {
                cnt++;
            } else if (s.charAt(i) != c) {
                list.add(new Node(c, cnt));
                c = s.charAt(i);
                cnt = 1;
            }
        }
        list.add(new Node(c, cnt));

        int maxi = 0;
        for(int i = 1; i < list.size(); i++) {
            int cnt1 = list.get(i - 1).cnt;
            int cnt2 = list.get(i).cnt;
            maxi = Math.max(maxi, Math.min(cnt1, cnt2));
        }
        System.out.println(maxi * 2);
    }
}

