
import java.util.*;
import java.io.*;

public class P17298 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Integer> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int [] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }


        for (int i = 0; i < n; i++) {
            int num = nums[n-1-i];
            while(!stack.isEmpty() && num >= stack.peek()) {
                stack.pop();
            }
            if(stack.isEmpty()) {
                result.add(-1);
            }else {
                result.add(stack.peek());
            }

            stack.add(num);
        }

        for (int i = 0; i < n; i++) {
            bw.write(result.get(n-1-i)+ " ");
        }

        bw.flush();
        bw.close();
    }
}
