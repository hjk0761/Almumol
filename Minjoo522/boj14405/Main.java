import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] pikachu = {"pi", "ka", "chu"};
        String s = sc.nextLine();

        while (s.length() > 0) {
            boolean flag = false;
            String target = "";
            for (int i = 0; i < pikachu.length; i++) {
                if (s.startsWith(pikachu[i])) {
                    flag = true;
                    target = pikachu[i];
                }
            }
            if (!flag) {
                System.out.println("NO");
                return;
            }
            s = s.substring(target.length());
        }

        System.out.println("YES");
    }
}
