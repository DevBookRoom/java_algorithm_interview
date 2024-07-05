public class Solution {
    public ListNode oddEvenList(ListNode head) {
        ListNode odd1 = null, odd2 = null;
        ListNode even1 = null, even2 = null;
        ListNode current = head;
        int index = 1;

        while (current != null) {
            if (index % 2 != 0) {
                // 홀수 인덱스 노드
                if (odd1 == null) {
                    odd1 = current;
                    odd2 = odd1;
                } else {
                    odd2.next = current;
                    odd2 = odd2.next;
                }
            } else {
                // 짝수 인덱스 노드
                if (even1 == null) {
                    even1 = current;
                    even2 = even1;
                } else {
                    even2.next = current;
                    even2 = even2.next;
                }
            }
            current = current.next;
            index++;
        }

        if (odd2 != null) odd2.next = even1; // 홀수 리스트 짝수 리스트 연결
        if (even2 != null) even2.next = null; // 짝수 리스트 끝을 null로 설정

        return odd1 != null ? odd1 : even1; // 홀수 리스트부터 리턴
    }
}
