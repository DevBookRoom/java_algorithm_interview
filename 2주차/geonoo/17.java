public class Solution {
    public ListNode swapPairs(ListNode head) {
        // 헤드 반환용 더미 노드
        ListNode dummy = new ListNode(0);
        // 더미 노드의 다음 노드를 헤드로 설정
        dummy.next = head;
        // 이전 노드를 더미 노드로 초기화
        ListNode prev = dummy;

        // 리스트 끝까지 두 노드씩 묶어서 반복
        while (prev.next != null && prev.next.next != null) {
            ListNode first = prev.next;
            ListNode second = first.next;

            // 스왑
            first.next = second.next;
            second.next = first;
            prev.next = second;

            // 이전 노드를 앞으로 이동
            prev = first;
        }

        return dummy.next;
    }
}
