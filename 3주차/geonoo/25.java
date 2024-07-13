class MyCircularQueue {
    private int[] data;
    private int front, rear, size;

    // 큐 초기화
    public MyCircularQueue(int k) {
        data = new int[k];
        front = 0;
        rear = -1;
        size = 0;
    }

    // 원형 큐에 값 추가
    public boolean enQueue(int value) {
        // 비어있을 경우 값 추가
        if (!isFull()) {
            // rear 포인터 한 칸 앞으로 이동, 최대 크기를 초과하면 나머지 위치로 이동
            rear = (rear + 1) % data.length;
            // 비어있는 rear 위치에 값 삽입
            data[rear] = value;
            size++;
            return true;
        } else {
            return false;
        }

    }

    // 원형 큐에서 값 제거
    public boolean deQueue() {
        // 비어있지 않을 경우 값 제거
        if (!isEmpty()) {
            // front 포인터 한 칸 앞으로 이동, 최대 크기를 초과하면 나머지 위치로 이동
            front = (front + 1) % data.length;
            size--;
            return true;
        } else {
            return false;
        }
    }

    // 큐의 맨 앞쪽 값을 가져옴
    public int Front() {
        return (isEmpty() ? -1 : data[front]);
    }

    // 큐의 마지막 값을 가져옴
    public int Rear() {
        return (isEmpty() ? -1 : data[rear]);
    }

    // 큐가 비어있는지 확인
    public boolean isEmpty() {
        return size == 0;
    }

    // 큐가 가득 찼는지 확인
    public boolean isFull() {
        return size == data.length;
    }
}
