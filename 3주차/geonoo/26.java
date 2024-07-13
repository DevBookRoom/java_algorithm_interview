class MyCircularDeque {
    private int[] data;
    private int front, rear, size, count;

    // Deque 초기화
    public MyCircularDeque(int k) {
        data = new int[k];
        front = 0;
        rear = 0;
        size = k;
        count = 0;
    }

    // Deque의 앞에 요소를 추가
    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        front = (front - 1 + size) % size;
        data[front] = value;
        count++;
        if (count == 1) {
            rear = front;
        }
        return true;
    }

    // Deque의 뒤에 요소를 추가
    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        data[rear] = value;
        rear = (rear + 1) % size;
        count++;
        if (count == 1) {
            front = rear;
        }
        return true;
    }

    // Deque의 앞쪽 요소를 제거
    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        front = (front + 1) % size;
        count--;
        return true;
    }

    // Deque의 뒤쪽 요소를 제거
    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        rear = (rear - 1 + size) % size;
        count--;
        return true;
    }

    // Deque의 앞쪽 요소 가져옴
    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        return data[front];
    }

    // Deque의 뒤쪽 요소 가져옴
    public int getRear() {
        if (isEmpty()) {
            return -1;
        }
        return data[(rear - 1 + size) % size];
    }

    // Deque가 비어있는지 확인
    public boolean isEmpty() {
        return count == 0;
    }

    // Deque가 가득 찼는지 확인
    public boolean isFull() {
        return count == size;
    }
}