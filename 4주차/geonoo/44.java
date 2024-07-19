import java.util.*;

public class Solution {
    public static int networkDelayTime(int[][] times, int n, int k) {
        // 그래프 초기화
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int[] time : times) {
            graph.get(time[0]).add(new int[]{time[1], time[2]});
        }

        // 다익스트라 알고리즘을 위한 우선순위 큐 초기화
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new int[]{k, 0});

        // 최소 거리를 저장하는 배열 초기화
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        // 다익스트라 알고리즘 수행
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int node = curr[0];
            int time = curr[1];

            if (time > dist[node]) {
                continue;
            }

            for (int[] edge : graph.get(node)) {
                int nextNode = edge[0];
                int nextTime = time + edge[1];

                if (nextTime < dist[nextNode]) {
                    dist[nextNode] = nextTime;
                    pq.add(new int[]{nextNode, nextTime});
                }
            }
        }

        // 모든 노드에 도달하는 데 걸리는 최대 시간 계산
        int maxTime = Arrays.stream(dist).skip(1).max().getAsInt();
        return maxTime == Integer.MAX_VALUE ? -1 : maxTime;
    }
}
