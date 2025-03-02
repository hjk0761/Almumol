import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int p = sc.nextInt();
        int c = sc.nextInt();

        int result = 0;

        if (a + c > p) {
            result = a + c;
        } else {
            result = p;
        }

        System.out.println(result);
    }
}
