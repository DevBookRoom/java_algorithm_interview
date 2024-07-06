public class Number13 {
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head, slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        if (fast != null)
            slow = slow.next;


        ListNode rev = null;
        while (slow != null) {

            ListNode next = slow.next;
            slow.next = rev;
            rev = slow;
            slow = next;
        }


        while (rev != null) {

            if (rev.val != head.val)
                return false;
            rev = rev.next;
            head = head.next;
        }
        return true;
    }
}