class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // 헤드 반환용 더미 노드
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

        // 리스트 돌면서 병합
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }

        // 남은 노드 처리
        if (list1 != null) {
            current.next = list1;
        } else {
            current.next = list2;
        }

        // 더미 노드의 다음 노드가 병합된 리스트의 헤드
        return dummy.next;
    }
}
