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
    public ListNode oddEvenList(ListNode head) {
        if(head==null)return head;
        //odd: 홀수번째 노드를 순회
        //even: 짝수번째 노드를 순회
        ListNode odd=head,even=head.next;

        ListNode evenHead=even;

        while(odd.next!=null && even.next!=null){
            odd.next=odd.next.next;
            even.next=even.next.next;
            odd=odd.next;
            even=even.next;
        }
        //while문이 끝난 후에 odd.next는 가장 마지막 값이기 떄문에 그 뒤에 짝수 NodeList붙임
        odd.next=evenHead;
        return head;

    }
}