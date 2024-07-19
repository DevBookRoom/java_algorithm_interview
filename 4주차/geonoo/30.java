import java.util.LinkedList;

class MyHashMap {
    // 연결리스트로 노드 객체 생성
    private LinkedList<Entry>[] node;

    // Entry -> 키-값 쌍을 저장하는 클래스
    private static class Entry {
        int key;
        int value;

        Entry(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public MyHashMap() {
        node = new LinkedList[1000000];
    }

    public void put(int key, int value) {
        int index = key % node.length;
        if (node[index] == null) {
            node[index] = new LinkedList<>();
        }
        for (Entry entry : node[index]) {
            if (entry.key == key) {
                // 키가 존재하면 값을 업데이트
                entry.value = value;
                return;
            }
        }
        node[index].add(new Entry(key, value));     // 새로운 키-값 쌍을 추가
    }

    public int get(int key) {
        int index = key % node.length;
        LinkedList<Entry> entries = node[index];
        if (entries != null) {
            for (Entry entry : entries) {
                if (entry.key == key) {
                    return entry.value;
                }
            }
        }
        return -1;      // 키에 대한 매핑이 없는 경우
    }

    public void remove(int key) {
        int index = key % node.length;
        LinkedList<Entry> entries = node[index];
        if (entries != null) {
            entries.removeIf(entry -> entry.key == key);
        }
    }
}
