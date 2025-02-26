import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            String[] lengths = br.readLine().split(" ");
            int frist = Integer.parseInt(lengths[0]);
            int second = Integer.parseInt(lengths[1]);
            int third = Integer.parseInt(lengths[2]);
            if(frist == 0 && second == 0 && third == 0) return;
            int slop = Math.max(frist, Math.max(second, third));
            int ans = (slop * slop) - (frist * frist) - (second * second) - (third * third);
            if(ans == -1 * slop * slop) {
                System.out.println("right");
                continue;
            }
            System.out.println("wrong");
        }
    }
}
