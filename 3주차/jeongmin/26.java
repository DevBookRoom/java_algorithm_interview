class MyCircularQueue {
    //이중 연결 리스트로 사용할 클래스 선언
    static class DoublyLinkedList{
        //왼쪽으로 연결할 이중 연결 리스트
        DoublyLinkedList left;
        //오른쪽으로 연결할 이중 연결 리스트
        DoublyLinkedList right;
        int val;
    }
    public DoublyLinkedList(int val){
        this.val=val;
    }
    int len;//현재 큐의 크기
    int k;//전체 큐의 크기
    DoublyLinkedList head;//이중 연결 리스트 head 노드
    DoublyLinkedList tail;//이중 연결 리스트 tail 노드
    public MyCircularQueue(int k) {
        //아중 연결 리스트 2개 생성
        head=new DoublyLinkedList(0);
        tail=new DoublyLinkedList(0);

        //서로연결
        head.right=tail;
        tail.left=head;

        //전체 큐의 크기 지정
        this.k=k;

        //현재 큐의 크기 지정
        this.len=0;
    }

    public boolean enQueue(int value) {

    }

    public boolean deQueue() {

    }

    public int Front() {

    }

    public int Rear() {

    }

    public boolean isEmpty() {
        //현재 큐의 크기가 0이면 비어있음
        return len==0;
    }

    public boolean isFull() {
        //현재 큐의 크기가 처음 선언한 큐의 크기와 일치하면 꽉차 있음
        return len==k;
    }
}

