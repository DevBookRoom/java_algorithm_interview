class TrieNode{
    boolean word;
    TrieNode[] children;
    public TrieNode(){
        children=new TrieNode[26];
        word=false;
    }
}


class Trie {

    TrieNode root;
    public Trie() {
        root=new TrieNode();
    }

    //단어삽입
    public void insert(String word) {
        //루트부터 시작
        TrieNode cur=root;
        //단어의 문자를 차례대로 반복하며 자식노드구성
        for(char c:word.toCharArray()){

            //해당 문자의 자식노드가 존재하지않으면 신규 트라이 노드 생성
            //a가 인덱스0,z는 인덱스 25가됨
            if(cur.children[c-'a']==null)
                cur.children[c-'a']=new TrieNode();
            //자식 노드를 현재 노드로 교체
            cur=cur.children[c-'a'];
        }
        //단어가 완성된 후 이므로 현재노드는 단어의 끝을 표시하기위해 true 설정
        cur.word=true;

    }

    //단어 존재 여부 판별
    public boolean search(String word) {
        //루트부터 시작
        TrieNode cur=root;
        //단어의 문자를 차례대로 반복하며 자식노드 구성
        for(char c:word.toCharArray()){
            //자식노드가 존재하지않으면 false리턴
            if(cur.children[c-'a']==null)return false;
            //자식노드를 현재노드로 교체
            cur=cur.children[c-'a'];
        }
        //마지막문자인지
        // 현재 노드가 마지막문자인지 확인
        return cur.word==true;
    }

    //문자열로 시작 단어 존재 여부 판별
    public boolean startsWith(String prefix) {
        //루트부터 시작
        TrieNode cur=root;
        //단어의 문자를 차례대로 반복하며 자식노드구성
        for(char c:prefix.toCharArray()){
            //자식노드가 존재하지 않으면 false리턴
            if(cur.children[c-'a']==null)return false;
            cur=cur.children[c-'a'];
        }
        return true;//false면 에러뜸
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */