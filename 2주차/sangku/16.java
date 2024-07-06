import java.math.BigInteger;

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

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l1Reverse = reverseList(l1);
        ListNode l2Reverse = reverseList(l2);

        BigInteger res = toBigInteger(l1Reverse).add(toBigInteger(l2Reverse));
        return toReversedLinkedList(res);
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null, node = head;

        while (node != null) {
            ListNode next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }
        return prev;
    }

    public BigInteger toBigInteger(ListNode node) {
        String val = "";
        while (node != null) {
            val += node.val;
            node = node.next;
        }
        return new BigInteger(val);
    }

    public ListNode toReversedLinkedList(BigInteger val) {
        ListNode prev = null, node = null;

        for (char c : val.toString().toCharArray()) {
            node = new ListNode(Character.getNumericValue(c));
            node.next = prev;
            prev = node;
        }
        return node;
    }
}