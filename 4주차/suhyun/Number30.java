class MyHashMap {

    // 사이즈
    private static int SIZE = 1000000;

    // 각 해쉬맵에 들어갈 노드들
    class Node {
        int key;
        int val;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    // 초기화
    LinkedList<Node>[] data = new LinkedList[SIZE];;

    // 키에 노드가 있는지 확인
    Node searchKey(LinkedList<Node> list, int key) {
        if (list == null) {
            return null;
        }
        for (Node node : list) {
            if (node.key == key) {
                return node;
            }
        }
        return null;
    }

    public void put(int key, int val) {
        int hashcode = key;
        int index = hashcode % data.length;

        LinkedList<Node> list = data[index];

        if (list == null) {
            list = new LinkedList<Node>();
            data[index] = list;
        }

        Node node = searchKey(list, key);
        if (node == null) {
            // node.val=-1;
            list.addLast(new Node(key, val));
        } else {
            node.val = val;
        }

    }

    public int get(int key) {

        int hashcode = key;
        int index = hashcode % data.length;

        LinkedList<Node> list = data[index];

        Node node = searchKey(list, key);
        return node == null ? -1 : node.val;
    }

    public void remove(int key) {
        int hashcode = key;
        int index = hashcode % data.length;

        data[index].remove();
    }

}

class MyHashMap2 {

    int[] map = new int[1000001];

    public MyHashMap() {
        Arrays.fill(data, -1);
    }

    public void put(int key, int val) {
        map[key] = val;
    }

    public int get(int key) {
        return map[key];
    }

    public void remove(int key) {
        map[key] = -1;
    }

}
