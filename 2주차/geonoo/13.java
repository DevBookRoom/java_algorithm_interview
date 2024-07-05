import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public boolean isPalindrome(ListNode head) {
        // 데크 구현체를 연결리스트로 선언
        Deque<Integer> deque = new LinkedList<>();
        ListNode current = head;

        // 리스트의 모든 값을 데크에 추가
        // addLast() -> 데크의 끝에 값 추가
        // next -> 다음 노드의 포인터
        while (current != null) {
            deque.addLast(current.val);
            current = current.next;
        }

        // 데크의 앞뒤 값을 비교해서 팰린드롬 여부 확인
        // removeFirst(), removeLast() -> 데크 값 제거 메서드
        while (deque.size() > 1) {
            if (!deque.removeFirst().equals(deque.removeLast())) {
                return false;
            }
        }

        return true;
    }
}

// 책에서 말하는 우아한 풀이.
// 데크 쓰는게 더 직관적인 것 같음.
//class Solution {
//    public boolean isPalindrome(ListNode.java head) {
//        ListNode.java fast = head, slow = head;
//        // 빠른 러너가 끝까지 갈 때까지 느린 러너와 함께 진행
//        while (fast != null && fast.next != null) {
//            fast = fast.next.next;
//            slow = slow.next;
//        }
//        // 홀수 개일 때 느린 러너가 한 칸 더 앞으로 가도록 처리
//        if (fast != null)
//            slow = slow.next;
//
//        // 중간에 도달한 느린 러너를 기준으로 하여 역순 연결 리스트를 만든다
//        ListNode.java rev = null;
//        while (slow != null) {
//            // 느린 러너로 역순 연결 리스트 rev를 만들어 나간다
//            ListNode.java next = slow.next;
//            slow.next = rev;
//            rev = slow;
//            slow = next;
//        }
//
//        // rev 연결 리스트를 끝까지 이동하며 비교
//        while (rev != null) {
//            // 역순 연결 리스트 rev와 기존 연결 리스트 head를 차례대로 비교
//            if (rev.val != head.val)
//                return false;
//            rev = rev.next;
//            head = head.next;
//        }
//        return true;
//    }
//}
