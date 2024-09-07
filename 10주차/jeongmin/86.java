import java.util.*;

class Solution {
    public int leastInterval(char[] tasks, int n) {
        // 각 작업의 빈도 수 계산
        int[] freqs = new int[26];
        for (char c : tasks) freqs[c - 'A']++;

        // 최대 빈도수를 우선 순위로 두는 우선순위 큐
        Queue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int f : freqs)
            if (f > 0) pq.add(f);

        int result = 0;

        // 작업을 처리
        while (!pq.isEmpty()) {
            int intervals = 0;
            List<Integer> list = new ArrayList<>();

            // 최대 n + 1개의 작업을 처리
            for (int i = 0; i <= n; i++) {
                if (!pq.isEmpty()) {
                    int frequency = pq.poll();
                    intervals++;
                    result++;
                    if (frequency > 1) list.add(frequency - 1);
                }
            }

            // 남아 있는 작업들을 다시 큐에 넣음
            pq.addAll(list);

            // 남은 작업이 있으면 대기 시간이 발생
            if (!pq.isEmpty()) result += n + 1 - intervals;
        }

        return result;
    }
}
