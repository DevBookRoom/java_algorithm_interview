import java.math.BigInteger;
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

    public ListNode reverseList(ListNode head){
        ListNode prev=null,node=head;
        while(node!=null){
            ListNode next=node.next;
            node.next=prev;//다음노드에 이전노드를 넣어
            prev=node;//이전노드에 현재노드를 넣어
            node=next;//현재노드에 다음 노드넣음
        }
        return prev;
    }
    public BigInteger toBigInt(ListNode node){
        String val="";
        //연결리스트 순회하며 한글자씩 문자열로 만든 다음 숫자로 변경
        //문제 예제 상 큰값이 들어가서 BigInteger사용
        while(node!=null){
            val+=node.val;
            node=node.next;
        }
        return new BigInteger(val);
    }
    //역순 연결리스트 만들기
    public ListNode toReverseLinkedList(BigInteger val){
        ListNode prev=null,node=null;

        for(char c:String.valueOf(val).toCharArray()){
            //char->int형으로 변환
            node=new ListNode(Character.getNumericValue(c));
            node.next=prev;
            prev=node;
        }
        return node;
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode rvs1=reverseList(l1);
        ListNode rvs2=reverseList(l2);

        BigInteger result=toBigInt(rvs1).add(toBigInt(rvs2));

        return toReverseLinkedList(result);
    }
}