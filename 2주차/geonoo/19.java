public class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // 헤드 반환용 더미 노드
        ListNode dummy = new ListNode(0);
        // 더미 노드의 다음 노드를 헤드로 설정
        dummy.next = head;
        // 이전 노드를 더미 노드로 초기화
        ListNode prev = dummy;

        // 구간의 시작점 이전 노드로 이동
        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }

        // 구간의 첫 번째 노드를 start로 지정
        ListNode start = prev.next;
        ListNode temp = start.next;

        // 구간을 반전
        for (int i = 0; i < right - left; i++) {
            start.next = temp.next;
            temp.next = prev.next;
            prev.next = temp;
            temp = start.next;
        }

        return dummy.next;
    }
}
