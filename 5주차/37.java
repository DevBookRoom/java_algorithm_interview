import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public void dfs(List<List<Integer>> results, List<Integer> prevElements, List<Integer> elements) {
        // 리프 노드에 도달하면 결과에 추가
        if (elements.isEmpty()) {
            // 자바 8+의 스트림을 이용해 prevElements의 내용을 결과에 삽입
            results.add(prevElements.stream().collect(Collectors.toList()));
            return;
        }

        // 전달받은 엘리먼트를 모두 탐색
        for (Integer e : elements) {
            // 전달받은 엘리먼트에서 현재 엘리먼트를 제외하고 nextElements로 새롭게 구성
            List<Integer> nextElements = new ArrayList<>(elements);
            nextElements.remove(e);

            // prevElements는 기존 값에 현재 엘리먼트 추가
            prevElements.add(e);

            // 재귀 DFS
            dfs(results, prevElements, nextElements);

            // 돌아온 이후에는 prevElements에서 현재 엘리먼트 삭제
            prevElements.remove(e);
        }
    }

    public List<List<Integer>> permute(List<Integer> elements) {
        List<List<Integer>> results = new ArrayList<>();
        dfs(results, new ArrayList<>(), elements);
        return results;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<Integer> elements = List.of(1, 2, 3);
        List<List<Integer>> permutations = solution.permute(elements);
        System.out.println("All permutations: " + permutations);
    }
}
