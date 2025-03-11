import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int studentNum = Integer.parseInt(input);

        if (studentNum % 4763 > 0) {
            System.out.println(0);
            System.exit(0);
        }

        int tmp = studentNum / 4763;

        List<List<Integer>> results = new ArrayList<>();
        for (int i = 0; i <= 200; i++) {
            for (int j = 0; j <= 200; j++) {
                if (
                        tmp == i * 508 + j * 212
                                || tmp == i * 508 + j * 305
                                || tmp == i * 108 + j * 212
                                || tmp == i * 108 + j * 305
                ) {
                    results.add(List.of(i, j));
                }
            }
        }

        results.sort((a, b) -> {
            if (!a.get(0).equals(b.get(0))) {
                return a.get(0) - b.get(0);
            } else {
                return a.get(1) - b.get(1);
            }
        });

        System.out.println(results.size());
        for (List<Integer> list : results) {
            System.out.println(list.get(0) + " " + list.get(1));
        }
    }
}
