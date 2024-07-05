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
    public ListNode swapPairs(ListNode head) {
        //스왑을 진행할 노드 선언
        ListNode node=head;
        //현재노드와 다음노드가 존재하면 계속 진행
        while(node!=null&&node.next!=null){
            //임시변수를 이용해 값만 교환
            int tmp;
            tmp=node.val;
            node.val=node.next.val;
            node.next.val=tmp;
            //두칸 앞으로 이동
            node=node.next.next;
        }

        return head;
    }
}