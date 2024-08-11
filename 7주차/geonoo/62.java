class Trie {
    TrieNode root;

    // 클래스 생성 시 루트로 빈 트라이 노드 생성
    public Trie() {
        root = new TrieNode();
    }

    // 단어 삽입
    public void insert(String word) {
        // 루트부터 시작
        TrieNode now = root;

        // 단어의 문자를 차례대로 반복하며 자식 노드 구성
        for (char c : word.toCharArray()) {
            // 해당 문자의 자식 노드가 존재하지 않으면 신규 trie 노드 생성
            // 인덱스는 'a': 0, 'z': 25
            if (now.children[c - 'a'] == null) {
                now.children[c - 'a'] = new TrieNode();
            }
            // 자식 노드를 현재 노드로 교체
            now = now.children[c - 'a'];
        }

        now.word = true;
    }

    // 단어 존재 여부 판별
    public boolean search(String word) {
        TrieNode now = root;

        for (char c : word.toCharArray()) {
            if (now.children[c - 'a'] == null) {
                return false;
            }

            now = now.children[c - 'a'];
        }

        return now.word;
    }

    // 문자열로 시작 단어 존재 여부 판별
    public boolean startsWith(String prefix) {
        TrieNode now = root;

        for (char c : prefix.toCharArray()) {
            if (now.children[c - 'a'] == null) {
                return false;
            }

            now = now.children[c - 'a'];
        }
        // 탐색이 종료되면 항상 true 리턴, 시작 여부만 판별하면 되므로 단어 완성 여부가 false여도 관계 X
        return true;
    }

}

class TrieNode {
    // 단어 완성 여부
    boolean word;
    // 트라이의 자식 노드들
    TrieNode[] children;
    public TrieNode() {
        // 자식 노드는 알파벳 개수 26개까지 가능
        children = new TrieNode[26];
        word = false;
    }
}
