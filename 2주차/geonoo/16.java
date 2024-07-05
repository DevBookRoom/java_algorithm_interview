public class Solution {
    // 각 자리 숫자를 더하고, 자릿수를 넘는 값은 다음 자리로 올림
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 헤드 반환용 더미 노드
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        // 자리 올림
        int up = 0;

        while (l1 != null || l2 != null) {
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            int sum = up + x + y;
            up = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        if (up > 0) {
            current.next = new ListNode(up);
        }

        return dummy.next;
    }
}
