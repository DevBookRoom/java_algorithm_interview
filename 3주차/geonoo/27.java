import java.util.PriorityQueue;

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        // 우선순위 큐를 사용하여 리스트의 노드를 정렬
        PriorityQueue<ListNode> queue = new PriorityQueue<>((a, b) -> a.val - b.val);

        // 모든 리스트의 첫 번째 노드를 큐에 추가
        for (ListNode node : lists) {
            if (node != null) {
                queue.offer(node);
            }
        }

        // 더미 헤드 생성
        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;

        // 큐에서 노드를 하나씩 꺼내어 연결 리스트를 생성
        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            current.next = node;
            current = current.next;

            // 다음 노드를 큐에 추가
            if (node.next != null) {
                queue.offer(node.next);
            }
        }

        return dummyHead.next;
    }
}
