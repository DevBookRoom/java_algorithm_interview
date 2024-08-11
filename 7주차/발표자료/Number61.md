
### 문제 설명

이중 우선순위 큐는 다음 연산을 할 수 있는 자료구조를 말합니다.

| 명령어  | 수신 탑(높이)          |
| ---- | ----------------- |
| I 숫자 | 큐에 주어진 숫자를 삽입합니다. |
| D 1  | 큐에서 최댓값을 삭제합니다.   |
| D -1 | 큐에서 최솟값을 삭제합니다.   |

이중 우선순위 큐가 할 연산 operations가 매개변수로 주어질 때, 모든 연산을 처리한 후 큐가 비어있으면 [0,0] 비어있지 않으면 [최댓값, 최솟값]을 return 하도록 solution 함수를 구현해주세요.

### 제한사항

- operations는 길이가 1 이상 1,000,000 이하인 문자열 배열입니다.
- operations의 원소는 큐가 수행할 연산을 나타냅니다.
    - 원소는 “명령어 데이터” 형식으로 주어집니다.- 최댓값/최솟값을 삭제하는 연산에서 최댓값/최솟값이 둘 이상인 경우, 하나만 삭제합니다.
- 빈 큐에 데이터를 삭제하라는 연산이 주어질 경우, 해당 연산은 무시합니다.

### 아이디어 
- 파라미터를 split으로 쪼개고 알파벳에 따라 로직을 분기
- 목적은 최소 최대 찾는 것  

### 책 풀이 
- 우선순위 큐를 사용하여 값을 넣었을 때 최소힙용과 최대힙을 나눠서 초기화
- 각각 삽입은 동시에 하고 , 최댓값과 최솟값을 뽑을 때는 각각 최대힙과 최소힙에서 poll연산으로 찾은 뒤 remove로 제거 
```java
public class P61_1 {
    public int[] solution(String[] operations) {
        // 우선순위 큐 선언, 자바 기본은 최소 힙이므로 최대 힙으로 정렬 지정
        Queue<Integer> minHeap = new PriorityQueue<>();
        // 원래 우선순위 큐는 최소 힙인데 Collections.reverseOrder() 요거 써서 최대힙으로 변경하여 큐의 가장 큰 요소가 우선적으로 처리되도록 변경
        Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        // 명령어 목록을 하나씩 순회하면서 해당하는 작업 수행
        for (String operation : operations) {
            // 띄어쓰기를 기준으로 명령과 값 분리
            String[] op = operation.split(" ");
            // 삽입 연산
            if ("I".equals(op[0])) {
                minHeap.add(Integer.valueOf(op[1]));
                maxHeap.add(Integer.valueOf(op[1]));
            // 추출 연산
            } else if ("D".equals(op[0])) {
                // 값이 1인 경우 최댓값 추출
                if ("1".equals(op[1])) {
                    minHeap.remove(maxHeap.poll());
                // 값이 -1인 경우 최솟값 추출
                } else if ("-1".equals(op[1])) {
                    maxHeap.remove(minHeap.poll());
                }
            }
        }

        // 최종결과인 최댓값과 최솟값 추출
        Integer maxValue = maxHeap.poll();
        Integer minValue = minHeap.poll();

        // 값이 없다면 0, 아니라면 해당 값으로 리턴
        return new int[]{
                (maxValue == null) ? 0 : maxValue,
                (minValue == null) ? 0 : minValue};
    }
}
```

- 우선순위 큐라 정렬은 자동으로 됨
![](https://i.imgur.com/VDLYxFn.png)



### 내풀이
- 배열로 문제를 풀고 각 처리마다 정렬을 새로함 
- 이럴거면 큐로 푸는게 맞다...; 
```java
public static int[] solution(String[] operations) {  
    int[] answer = new int[2];  
    List<Integer> list = new ArrayList<>();  
    String alpha = "";  
    int num = 0;  
  
    for (String str : operations) {  
        Collections.sort(list);  
        alpha = str.split(" ")[0];  
        num = Integer.parseInt(str.split(" ")[1]);  
        if (alpha.equals("I")) {  
            list.add(num);  
        } else if (alpha.equals("D") && num == 1 && !list.isEmpty()) {  
            list.remove(list.size() - 1);  
        } else if (alpha.equals("D") && num == -1 && !list.isEmpty()) {  
            list.remove(0);  
        }  
    }  
    Collections.sort(list);  
    if (list.isEmpty()) {  
        answer = new int[]{0, 0};  
    } else {  
        answer[0] = list.get(list.size() - 1);  
        answer[1] = list.get(0);  
    }  
  
    return answer;  
}
```


### 후기
- 앞으로 뭐 정렬을 오름,내림차순 쓸 때는 우선정렬 큐를 쓰자