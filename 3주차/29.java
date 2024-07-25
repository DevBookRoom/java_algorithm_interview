class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer>pq=new PriorityQueue<>();
        for(int s:scoville){
            pq.add(s);
        }

        int answer = 1;
        while(pq.size()>=2){
            pq.add(pq.poll+(pq.poll()*2));
            if(pq.peek()>=k) return answer;
            answer++;
        }
        return -1;
    }
}