//[LeetCode 23] Merge K Sorted Lists - 우선순위 큐

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
    public ListNode mergeKLists(ListNode[] lists) {
        //queue는 fifo로 먼저 들어온 데이터를 먼저 방출하는데
        //priorityqueue는 우선순위가 높은 것부터 선출
        PriorityQueue<Integer> pq=new PriorityQueue<>();

        for(ListNode list:lists){
            while(list!=null){
                pq.add(list.add);
                list=list.next;
            }
        }
        ListNode head=new ListNode(0);
        ListNode next=head;

        while(!pq.isEmpty()){
            int i=pq.poll();//가장 앞에 있는 데이터를 꺼내서 return 하고 삭제
            next.next=new ListNode(i);
            next=next.next;
        }
        return head.next;

    }
}