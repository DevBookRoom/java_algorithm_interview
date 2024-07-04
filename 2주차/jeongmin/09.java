//[Leetcode 234] Palindrome Linked List
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
    public boolean isPalindrome(ListNode head) {

        Stack<Integer> st=new Stack<>();
        ListNode node=head;
        while(node!=null){//Listnode->stack에 복사해서 넣음
            st.add(node.val);
            node=node.next;
        }
        while(head!=null){//연결리스트를 앞에서 부터 이동하면서 값을 조회,스택은 뒤에서 부터 값을 빼면서 비교
            if(head.val!=st.pop()){
                return false;
            }
            head=head.next;
        }
        return true;


    }
}