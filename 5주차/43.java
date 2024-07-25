import java.util.*;

class Solution {
    // DFS 메서드
    public boolean dfs(Map<Integer, List<Integer>> finishToTakeMap, Integer finish, List<Integer> takes) {
        // 완료해야 하는 노드가 처리해야 하는 노드에 이미 포함되어 있다면
        // 그래프가 순환 구조이므로 false 리턴
        if (takes.contains(finish)) return false;

        // 완료해야 하는 코스에 값이 있다면
        if (finishToTakeMap.containsKey(finish)) {
            // 처리해야 하는 노드에 현재 완료해야 하는 노드 추가
            takes.add(finish);
            // 처리해야 하는 노드 순회
            for (Integer take : finishToTakeMap.get(finish)) {
                // 재귀 DFS, 탐색 결과가 false라면 false를 리턴한다.
                if (!dfs(finishToTakeMap, take, takes)) return false;
            }
            // 탐색 후에는 처리했으므로 노드 제거
            takes.remove(finish);
        }
        return true;
    }


