class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {

        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
        for (int[] time : times) {

            graph.putIfAbsent(time[0], new HashMap<>());
            graph.get(time[0]).put(time[1], time[2]);
        }

        Queue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(Map.Entry.comparingByValue());
        pq.add(new AbstractMap.SimpleEntry<>(k, 0));
        Map<Integer, Integer> dist = new HashMap<>();

        while (!pq.isEmpty()) {
            Map.Entry<Integer, Integer> cur = pq.poll();
            int u = cur.getKey();
            int dist_u = cur.getValue();

            if (!dist.containsKey(u)) {
                dist.put(u, dist_u);
                if (graph.containsKey(u)) {
                    for (Map.Entry<Integer, Integer> v : graph.get(u).entrySet()) {
                        int alt = dist_u + v.getValue();
                        pq.add(new AbstractMap.SimpleEntry<>(v.getKey(), alt));
                    }
                }
            }
        }

        if (dist.size() == n) {
            return Collections.max(dist.values());
        }

        return -1;
    }
}