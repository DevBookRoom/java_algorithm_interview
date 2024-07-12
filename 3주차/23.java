
package 문자열;

import java.util.LinkedList;
import java.util.Queue;

//큐는 선입선출, 스택은 후입선출
public class MyStack {
    Queue<Integer> queue=new LinkedList<>();
    public MyStack() {

    }

    public void push(int x) {
        queue.add(x);//{1,2}
        for(int i=1;i<queue.size();i++){
            //값을 remove하면 {2}가 되고 거기서 add를 하면{2,1}이 된다
            queue.add(queue.remove());//{2,1}
        }
    }

    public int pop() {
        return queue.remove();
    }

    public int top() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.size()==0;
    }
}




