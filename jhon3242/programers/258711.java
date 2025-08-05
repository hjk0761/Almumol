import java.util.*;

class Solution {
    
    static Map<Integer, List<Integer>> graph;
    static Map<Integer, List<Integer>> peeGraph;
    static int[] rank;
    static int N;
    
    public int[] solution(int[][] edges) {
        int[] answer = {};
        graph = new HashMap<>();
        peeGraph = new HashMap<>();
        
        N = 0;
        for (int[] edge: edges) {
            List<Integer> list = graph.computeIfAbsent(edge[0], (a) -> new ArrayList<>());
            List<Integer> peeList = peeGraph.computeIfAbsent(edge[1], (a) -> new ArrayList<>());
            list.add(edge[1]);
            // System.out.print(graph.get(1) + " ");
            // System.out.println(graph.get(1));
            peeList.add(edge[0]);
            N = Math.max(N, edge[0]);
            N = Math.max(N, edge[1]);
        }
        
        rank = new int[N + 1];
        for (int i = 1 ; i <= N; i++) {
            rank[i] = i;
        }
        
        int mid = getMid();
        for (int[] edge: edges) {
            if (edge[0] == mid) continue;
            union(edge[0], edge[1]);
        }
        for (int i = 1; i <= N; i++) {
            find(i);
        }
            
        int[] result = new int[4];
        result[0] = mid;
        Map<Integer, int[]> shape = initShape(mid);
        for (int next : graph.get(mid)) {
            // System.out.println(next);
            int[] tmp = shape.get(rank[next]);
            if (tmp[0] == tmp[1]) {
                result[1]++;
            } else if (tmp[0] - 1 == tmp[1]) {
                result[2]++;
            } else {
                result[3]++;
            }
        }
        // System.out.println(Arrays.toString(rank));
        
        return result;
    }
    
    private int getMid() {
        for (int key : graph.keySet()) {
            if (graph.get(key).size() >= 2 && !peeGraph.containsKey(key)) {
                return key;
            }
        }
        return -1;
    }
    
    private Map<Integer, int[]> initShape(int mid) {
        Map<Integer, int[]> store = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            int[] tmp = store.getOrDefault(rank[i], new int[2]);
            tmp[0]++;
            tmp[1] += graph.getOrDefault(i, new ArrayList()).size();
            store.put(rank[i], tmp);
        }
        return store;
    }
  
    
    private String knowGraph(int start) {
        int nCount = 0;
        int roadCount = 0;
        int target = rank[start];
        for (int i = 1; i<= N; i++) {
            if (rank[i] == target) {
                nCount++;
                roadCount += graph.getOrDefault(i, new ArrayList()).size();
            }
        }
        if (nCount == roadCount) {
            return "donut";
        }
        if (nCount - 1 == roadCount) {
            return "stick";
        }
        return "eight";
    }
    
    private void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a < b) {
            rank[b] = a;
        } else {
            rank[a] = b;
        }
    }
    
    private int find(int x) {
        if (x != rank[x]) {
            rank[x] = find(rank[x]);
        }
        return rank[x];
    }
}
