import java.util.ArrayDeque;
import java.util.Deque;

public class Number24 {
    Deque<Integer> input = new ArrayDeque<>();
    Deque<Integer> output = new ArrayDeque<>();

    public void push(int x) {
        input.push(x);
    }

    public int pop() {
        // output이 비어있을 수도 있으니 처리
        peek();
        return output.pop();
    }

    public int peek() {

        if (output.isEmpty()) {
            while (!input.isEmpty()) {
                // input 역순으로 저장
                output.push(input.pop());
            }
        }
        return output.peek();
    }

    public boolean empty() {
        return input.isEmpty() && output.isEmpty();
    }
}
