class Solution {
    public int[] solution(String[] operations) {
        //우선순위 큐선언,자바 기본은 최소 힙이므로 최대힙으로 정렬지정
        Queue<Integer> minHeap=new PriorityQueue<>();
        Queue<Integer> maxHeap=new PriorityQueue<>(Collections.reverseOrder());

        //명령어 목록을 하나씩 순회하면서 해당하는 작업 수행
        for(String operation:operations){
            String[]op=operation.split(" ");

            //삽입
            if("I".equals(op[0])){
                minHeap.add(Integer.valueOf(op[1]));
                maxHeap.add(Integer.valueOf(op[1]));
            }
            //추출
            else if("D".equals(op[0])){
                //값이 1인 경우 최대값 추출
                if("1".equals(op[1])){
                    minHeap.remove(maxHeap.poll());
                    //값이 -1인경우 최솟값 추출
                }else if("-1".equals(op[1])){
                    maxHeap.remove(minHeap.poll());
                }
            }
        }

        Integer maxValue=maxHeap.poll();
        Integer minValue=minHeap.poll();

        return new int[]{
                (maxValue==null)?0:maxValue,
                (minValue==null)?0:minValue;
        }
    }
}