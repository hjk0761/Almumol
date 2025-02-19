/*
(10C2 + 10C3 + 10C4 + ... 10C10) * 20

*/

import java.util.*;

class Solution {

    private Map<Integer, Map<String, Integer>> repo = new HashMap<>();

    public String[] solution(String[] orders, int[] course) {
        String[] answer = {};
        List<String> result= new ArrayList<>();
        // init repo
        for (int i = 2; i <= 10; i++) {
            repo.put(i, new HashMap<>());
        }

        // loop orders and get order option using dfs
        for (String order : orders) {
            char[] arr = order.toCharArray();
            Arrays.sort(arr);
            dfs(new String(arr), 0, "");
        }

        // System.out.println(repo);

        for (int size : course) {
            Map<String, Integer> opRepo = repo.get(size);

            if (opRepo.isEmpty()) {
                continue;
            }

            int maxOrderCount = opRepo.values().stream()
                    .reduce(Integer::max)
                    .get();

            if (maxOrderCount < 2) {
                continue;
            }

            for (String menu : opRepo.keySet()) {
                if (opRepo.get(menu) == maxOrderCount) {
                    result.add(menu);
                }
            }
        }
        Collections.sort(result);
        return result.toArray(new String[0]);
    }

    private void dfs(String origin, int cur , String result) {
        if (result.length() >= 2) {
            updateOption(result);
        }
        if (cur == origin.length()) {
            return;
        }
        for (int i = cur; i < origin.length(); i++) {
            dfs(origin, i + 1, result + origin.substring(i, i + 1));
        }
    }

    private void updateOption(String option) {
        Map<String, Integer> opRepo = repo.get(option.length());
        opRepo.put(option, opRepo.getOrDefault(option, 0) + 1);
    }
}
