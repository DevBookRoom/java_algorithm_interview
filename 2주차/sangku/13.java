import java.util.Deque;
import java.util.LinkedList;

public class ListNode {
    int val;
    ListNode next;
    ListNode(){}

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public boolean isPalindrome(ListNode head) {
        Deque<Integer> deque = new LinkedList<>();
        ListNode node = head;
        while (node != null) {
            deque.add(node.val);
            node = node.next;
        }

        while (!deque.isEmpty() && deque.size() > 1) {
            if (deque.pollFirst() != deque.pollLast()) {
                return false;
            }
        }
        return true;
    }

}