class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        HashMap<Integer, HashSet<Integer>> map = build(roads, n);
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j != i) 
                {
                    max = Math.max(map.get(i).size() + map.get(j).size() -          (map.get(i).contains(j) ? 1 : 0), max);
                }
            }
        }
        return max;
    }

    public HashMap<Integer, HashSet<Integer>> build(int[][] roads, int n) {
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i, new HashSet<>());  
        }
        for (int[] road : roads) {
            map.get(road[0]).add(road[1]);
            map.get(road[1]).add(road[0]);  
        }
        return map;
    }
}