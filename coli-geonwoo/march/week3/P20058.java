import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class P20058 {

    static int n;

    static int [] dx = {-1,1,0,0};
    static int [] dy = {0,0,-1,1};
    static int[][] data;
    static boolean [][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = (int) Math.pow(2, Double.parseDouble(st.nextToken()));
        int m = Integer.parseInt(st.nextToken());

        data = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                data[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int k = Integer.parseInt(st.nextToken());
            data = rotateData(k);
            decrease();
        }
        int sum = 0;
        int cnt =0;

        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if(data[i][j]>0 && !visited[i][j]) {
                    cnt = Math.max(cnt, bfs(i,j));
                }
                sum += data[i][j];
            }
        }

        System.out.println(sum);
        System.out.println(cnt);
    }


    static int [][] rotateData(int k) {
        int t = (int) Math.pow(2, k);
        int [][] temp = new int[n][n];

        for (int i = 0; i < n; i+=t) {
            for (int j = 0; j < n; j+=t) {
                rotate(i, j, t, temp);
            }
        }

        return temp;
    }

    static void rotate(int x, int y, int t, int [][] temp) {
        for(int i=0; i<t; i++) {
            for(int j=0; j<t; j++) {
                temp[x+i][y+j] = data[x+t - 1 - j][y+i];
            }
        }
    }

    static void decrease() {
        int [][] temp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(isDecrease(i,j) && data[i][j] > 0) {
                    temp[i][j] = data[i][j]-1;
                }else{
                    temp[i][j] = data[i][j];
                }
            }
        }
        data = temp;
    }

    static boolean isDecrease(int x, int y) {
        int cnt =0;

        for(int i=0; i<4; i++){
            int nx = x+dx[i];
            int ny = y+dy[i];

            if(nx<0 || ny<0|| nx>=n || ny>=n){
                continue;
            }

            if(data[nx][ny]>0){
                cnt++;
            }

        }

        return cnt <3;
    }

    static int bfs(int x, int y) {
        visited[x][y] = true;
        Deque<Node> q = new ArrayDeque<>();
        int cnt =1;
        q.add(new Node(x, y));

        while(!q.isEmpty()) {
            Node node = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if(nx<0 || ny<0|| nx>=n || ny>=n || visited[nx][ny] || data[nx][ny] ==0){
                    continue;
                }
                q.add(new Node(nx, ny));
                visited[nx][ny] = true;
                cnt++;
            }
        }

        return cnt;
    }

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
