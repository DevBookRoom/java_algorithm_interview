class Solution {
    static class Position {
        final int y;
        final int x;
        final int distance;

        public Position(int y, int x, int distance) {
            this.y = y;
            this.x = x;
            this.distance = distance;
        }
    }

    Queue<Position> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.distance));

    public void findPath(int y, int x, int distance, int[][] maps) {
        if (y >= 0 &&
                y < maps.length &&
                x >= 0 &&
                x < maps[0].length &&
                maps[y][x] != 0) {
            maps[y][x] = 0;
            pq.add(new Position(y, x, distance + 1));
        }
    }

    public int solution(int[][] maps) {

        pq.add(new Position(0, 0, 1));
        Map<Integer, Position> dist = new LinkedHashMap<>();

        while (!pq.isEmpty()) {

            Position cur = pq.poll();

            if (!dist.containsKey(cur.y * 1000 + cur.x)) {
                dist.put(cur.y * 1000 + cur.x, cur);

                findPath(cur.y, cur.x + 1, cur.distance, maps); // 동
                findPath(cur.y, cur.x - 1, cur.distance, maps); // 서
                findPath(cur.y + 1, cur.x, cur.distance, maps); // 남
                findPath(cur.y - 1, cur.x, cur.distance, maps); // 북
            }
        }

        if (dist.containsKey(((maps.length - 1) * 1000) + (maps[0].length - 1))) {
            return dist.get(((maps.length - 1) * 1000) + (maps[0].length - 1)).distance;
        }
        return -1;
    }
}