class Solution {
    static class Point{
        double distance;
        int[]point;

        public Point(double distance,int[]point){
            this.distance=distance;//거리
            this.point=point;//좌표
        }
    }
    public int[][] kClosest(int[][] points, int k) {
        //point 클래스를 저장하는 우선순위 큐로, 정렬기준은 distance로 한다.!
        PriorityQueue<Point> pq=new PriorityQueue<>(
                Comparator.comapringDouble(a->a.distance));

        for(int []point :points){
            //유클리드 거리 계산
            double distance=Math.sqrt((long)point[0]*point[0] + (long)point[1]*point[1]);
            //우선순위 큐에 거리와 좌푤를 point클래스로 담아 삽입
            pq.add(new Point(distance,point));
        }
        int [][]results=new int[k][];

        for(int i=0;i<k;i++){

            results[i]=pq.poll().point;
        }
        return results;

    }
}