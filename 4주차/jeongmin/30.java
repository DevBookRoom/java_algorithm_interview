class MyHashMap {

    public MyHashMap() {
        static class Node{
            int key,val;
            Node next;

            Node(int key,int val){
                this.key=key;
                this.val=val;
            }
        }

        //삽입
        public void put(int key, int value) {
            int index=key %nodes.length;
        }
        //조회
        public int get(int key) {

        }
        //삭제
        public void remove(int key) {

        }
    }


}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */