
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[] arr = new int[n];
            for(int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            List<Integer> list = new ArrayList<>();
            list.add(arr[0]);
            for(int i = 1; i < n; i++) {
                if (list.size() % 2 == 1) {
                    if (list.get(list.size() - 1) > arr[i]) {
                        list.add(arr[i]);
                    } else {
                        list.set(list.size() - 1, arr[i]);
                    }
                } else if (list.size() % 2 == 0) {
                    if (list.get(list.size() - 1) < arr[i]) {
                        list.add(arr[i]);
                    } else {
                        list.set(list.size() - 1, arr[i]);
                    }
                }
            }

            System.out.println(list.size());
        }
    }
}

