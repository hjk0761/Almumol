import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            String num = br.readLine();
            if(num.equals("0")) return;
            char[] nums = num.toCharArray();
            boolean isPalindrome = true;
            for(int i = 0; i <= ((nums.length - 1) / 2); i++) {
                if(nums[i] != nums[nums.length - 1 - i]) {
                    isPalindrome = false;
                    break;
                }
            }
            if(isPalindrome) System.out.println("yes");
            else System.out.println("no");
        }
    }
}
