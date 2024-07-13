import java.util.ArrayDeque;
import java.util.Deque;

class MyQueue {
    private Deque<Integer> input;
    private Deque<Integer> output;

    // 큐 초기화
    public MyQueue() {
        input= new ArrayDeque<>();
        output = new ArrayDeque<>();
    }

    // 큐의 뒤에 x추가
    public void push(int x) {
        input.push(x);
    }

    // 큐의 가장 앞 요소를 제거 후 값 반환
    public int pop() {
        moveInputToOutput();
        return output.pop();
    }


    // 큐의 가장 앞 요소의 값만 반환
    public int peek() {
        moveInputToOutput();
        return output.peek();
    }

    // 큐가 비어있는지 확인
    public boolean empty() {
        return input.isEmpty() && output.isEmpty();
    }

    // output이 비어있으면, input의 모든 요소를 output으로 옮김 -> 요소 순서 뒤집기.
    private void moveInputToOutput() {
        if (output.isEmpty()) {
            while (!input.isEmpty()) {
                output.push(input.pop());
            }
        }
    }
}