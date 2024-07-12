
package 문자열;
class MyCircularQueue {
    int[]q;
    int front=0,rear=-1,len=0;

    public MyCircularQueue(int k) {
        //k크기 사용할 int배열 크기선언
        this.q=new int[k];
    }

    public boolean enQueue(int value) {
        //꽉차 있지 않다면 삽입 진행
        if(!this.isFull()){
            this.rear=(this.rear+1)%this.q.length;//queue크기
            this.q[rear]=value;//한칸이동된뒤 값 삽입
            this.len++;
            return true;
        }else{
            return false;
        }
    }

    public boolean deQueue() {
        if(!this.isEmpty()){
            //한칸이동 후 최대크기를 초과하면 나머지 위치로 이동
            this.front=(this.front+1)%this.q.length;
            //현재 큐의 계산
            this.len--;
            return true;
        }else{
            return false;
        }
    }


    //맨앞에 있는 값 가져옴
    public int Front() {
        return this.isEmpty() ? -1 : this.q[this.front];
    }
    //맨뒤에 있는 값 가져옴
    public int Rear() {
        return this.isEmpty()?-1 :this.q[this.rear];
    }

    //현재 큐의 크기가 0이면 비어있음
    public boolean isEmpty() {
        return this.len==0;
    }

    //현재 큐의 크기가 전체 큐의 크기와 일치하면 꽉차있음
    public boolean isFull() {
        return this.len==this.q.length;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
