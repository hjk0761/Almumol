public class Main {
    // 8 5 3

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> maxPq = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> minPq = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());

            if (maxPq.size() == minPq.size()) {
                maxPq.add(num);
            } else {
                minPq.add(num);
            }

            if (minPq.isEmpty()) {
                sb.append(num).append("\n");
                continue;
            }
            int maxV = maxPq.poll();
            int minV = minPq.poll();

            if (maxV > minV) {
                maxPq.add(minV);
                minPq.add(maxV);
            } else {
                maxPq.add(maxV);
                minPq.add(minV);
            }
            sb.append(maxPq.peek()).append("\n");
        }
        System.out.println(sb);
    }
}
