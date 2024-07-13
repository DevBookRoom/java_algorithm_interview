
package 문자열;

import java.util.ArrayDeque;
import java.util.Deque;

//큐는 선입선출, 스택은 후입선출


public class MyQueue{
    //삽입할때 사용하는 스택 선언
    Deque<Integer> input = new ArrayDeque<>();
    //추출할때 사용하는 스택 선언
    Deque<Integer> output = new ArrayDeque<>();


    public void push(int x) {
        //삽입은 삽입 스택에 단순 추가
        input.push(x);//1->2 1
    }

    public int pop() {
        //추출 스택 조회하면서 비어있다면 처리
        peek();
        return output.pop();
    }

    public int peek() {
        if(output.isEmpty()){//output이 비어있다면
            while(!input.isEmpty()){//삽입스택이 비워질때까지 진행
                output.push(input.pop());//2를 빼고 output에 2-> 1를 뺴고 output 1,2
            }
        }
        return output.peek();//1
    }

    public boolean empty() {
        //둘다 비어야 있는것으로 처리
        return input.isEmpty()&&output.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */



