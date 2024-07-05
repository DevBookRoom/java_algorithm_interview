//206. 역방향 연결 리스트
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
    public ListNode reverseList(ListNode head) {

        ListNode prev=null,node=head;//이전값이 담길 노드 선언
        while(head!=null){
            ListNode next=head.next;//현재노드의 다음노드와 연결을 끊기 위해 다음노드 저장
            head.next=prev;//현재노드가 이전노드를 바라보게 하기
            prev=head;//이전노드를 현재노드로
            head=next;//다음노드를 현재노드로 변경
        }
        return prev;



    }
}