class MyCircularDeque {
    static class DoublyLinkedList{
        DoublyLinkedList left;
        DoublyLinkedList right;
        int val;
        public DoublyLinkedList(int val){
            this.val=val;
        }
    }


    public MyCircularDeque(int k) {
        int len;
        int k;
        DoublyLinkedList head;
        DoublyLinkedList tail;

        public MyCircularDeque(int k){
            head=new DoublyLinkedList(0);
            tail=new DoublyLinkedList(0);
            head.right=tail;
            tail.left=head;
            this.k=k;
            this.len=0;
        }

    }

    public boolean insertFront(int value) {
        if(isFull()) return false;
        DoublyLinkedList node=new DoublyLinkedList(value);
        node.left=tail.left;
        node.right=tail;

        tail.left.right=node;
        tail.left=node;
        len++;
        return true;
    }

    public boolean insertLast(int value) {
        if(isFull()){
            return false;
        }
        DoublyLinkedList node=new DoublyLinkedList(value);
        node.left=tail.left;
        node.right=tail;
        tail.left.right=node;
        tail.left=node;
        len++;
        return true;
    }

    public boolean deleteFront() {

    }

    public boolean deleteLast() {

    }

    public int getFront() {

    }

    public int getRear() {

    }

    public boolean isEmpty() {

    }

    public boolean isFull() {

    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */