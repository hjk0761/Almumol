package week6;

import java.io.*;

// 15:12 - 
public class BJ_30648 {
    private static final int MAX = 1000;
    public static void main(String[] args) throws IOException {

        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final String[] temp = br.readLine().split(" ");
        final int a = Integer.parseInt(temp[0]);
        final int b = Integer.parseInt(temp[1]);
        final int r = Integer.parseInt(br.readLine());


        final boolean[][] visited = new boolean[MAX][MAX];

        visited[a][b]=true;
        final int limit = r -2;
        int nextX = a;
        int nextY = b;
        int count = 0;
        while(true){
            if(nextX + nextY < limit){
                nextX +=1;
                nextY +=1;
            }else{
                nextX /= 2;
                nextY /= 2;
            }
            count++;
            if(visited[nextX][nextY]){
                break;
            }
            visited[nextX][nextY]=true;
        }
        System.out.println(count);
    }   
}

// 0 0
// 1초 후 2번째 조건에 따라 생성
// 0 0
// 5


