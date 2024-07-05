class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            // 다음 노드를 임시 저장
            ListNode next = current.next;
            // 현재 노드의 방향을 반전
            current.next = prev;
            // prev 포인터를 현재 노드로 이동
            prev = current;
            // current 포인터를 다음 노드로 이동
            current = next;
        }
        // prev가 새로운 헤드가 됨
        return prev;
    }
}
