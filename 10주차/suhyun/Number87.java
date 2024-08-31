import java.util.PriorityQueue;

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        var pq = new PriorityQueue<Point>((a, b) -> b.sum - a.sum);

        for (int i = 0; i < n; i++) {
            if (gas[i] - cost[i] >= 0)
                pq.add(new Point(i, gas[i] - cost[i]));
        }

        while (!pq.isEmpty()) {
            int index = pq.poll().index;
            int sum = gas[index];

            for (int i = 0; i < n; i++) {
                sum -= cost[(index + i) % n];
                if (sum < 0)
                    break;
                sum += gas[(index + i + 1) % n];
            }

            if (sum >= 0)
                return index;
        }

        return -1;
    }

    class Point {
        int index, sum;

        public Point(int index, int sum) {
            this.index = index;
            this.sum = sum;
        }
    }
}