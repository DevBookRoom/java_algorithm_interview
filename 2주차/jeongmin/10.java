/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    //연결리스트 뒤집기
    public ListNode reverseList(ListNode head){
        ListNode prev=null;
        ListNode node=head;
        while(node!=null){
            ListNode next=node.next;
            next=prev;
            prev=node;
            node=next;
        }
        return prev;
    }
    //연결리스트를 문자열로 연결 후 BigInteger로 형변환
    public BigInteger toBigInt(ListNode node) {
        String val = "";
        while (node != null) {
            val += node.val;
            node = node.next;
        }
        return new BigInteger(val);
    }
    //
    public ListNode toReversedLinkedList(BigInteger val){
        ListNode prev = null;
        ListNode node = null;

        for(char c : String.valueOf(val).toCharArray()){
            node = new ListNode(Character.getNumericValue(c));
            node.next = prev;
            prev = node;
        }

        return node;
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l1reversed=reverseList(l1);
        ListNode l2reversed=reverseList(l2);

        BigInteger result = toBigInt(l1reversed).add(toBigInt(l2reversed));

        return toReversedLinkedList(result);

    }
}