import java.util.LinkedList;
import java.util.Queue;

class MyStack {
    private Queue<Integer> queue;

    // 스택 초기화
    public MyStack() {
        queue = new LinkedList<>();
    }

    // 스택의 위에 x추가
    public void push(int x) {
        queue.add(x);
        // 새로 추가된 요소가 맨 앞에 오도록 큐의 모든 요소를 재정렬
        for (int i = 1; i < queue.size(); i++) {
            queue.add(queue.poll());
        }
    }

    // 큐의 가장 위 요소를 제거 후 값 반환
    public int pop() {
        return queue.poll();
    }

    // 스택의 가장 위 요소의 값만 반환
    public int top() {
        return queue.peek();
    }

    // 스택이 비어있는지 확인
    public boolean empty() {
        return queue.isEmpty();
    }
}
