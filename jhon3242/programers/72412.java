import java.util.*;

/*
4 * 3 * 3 * 3 * 100,000

*/

class Solution {
    static Map<String, List<Integer>> repo;
    public int[] solution(String[] info, String[] query) {
        int[] answer = {};
        List<Integer> result = new ArrayList<>();
        initMap();

        for (String inf : info) {
            String[] sp = inf.split(" ");
            dfs(sp, 0, "");
        }

        for (String key : repo.keySet()) {
            Collections.sort(repo.get(key));
        }


        // System.out.println(biSearch(new int[]{2, 2, 10, 42, 50}, 10));

        for (String quer : query) {
            quer = quer.replaceAll("and ", "");
            String[] sp = quer.split(" ");
            int score = Integer.parseInt(sp[sp.length - 1]);

            String key = sp[0] + sp[1] + sp[2] + sp[3];

            result.add(getValidCount(repo.get(key), score));
        }

        return result.stream()
                .mapToInt(Integer::valueOf)
                .toArray();
    }

    private int getValidCount(List<Integer> list, int score) {
        int start = 0;
        int end = list.size() - 1;
        int mid;

        while (start <= end) {
            mid = (start + end) / 2;
            if (list.get(mid) < score) start = mid + 1;
            else end = mid - 1;
        }
        return list.size() - start;
    }


    private void dfs(String[] arr, int cur, String result) {
        if (cur == 4) {
            repo.get(result).add(Integer.parseInt(arr[4]));
            return;
        }
        dfs(arr, cur + 1, result + arr[cur]);
        dfs(arr, cur + 1, result + "-");
    }

    private void initMap() {
        repo = new HashMap<>();

        String[] lan = {"java", "python", "cpp", "-"};
        String[] posi = {"backend", "frontend", "-"};
        String[] caree = {"junior", "senior" , "-"};
        String[] food = {"chicken", "pizza", "-"};

        for (String la : lan) {
            for (String po : posi) {
                for (String ca : caree) {
                    for (String fo : food) {
                        repo.put(la + po + ca + fo, new ArrayList<>());
                    }
                }
            }
        }
    }
}
