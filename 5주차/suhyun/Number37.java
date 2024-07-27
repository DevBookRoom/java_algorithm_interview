import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public void dfs(List<List<Integer>> results, List<Integer> prevElements, List<Integer> elements) {
        // 끝에 도달한 경우
        if (elements.isEmpty()) {
            // prevElements를 결과값에 추가
            results.add(prevElements.stream().collect(Collectors.toList()));
        }

        for (Integer e : elements) {
            // 전달받은 엘리먼트에서 현재 엘리먼트를 제외하고 nextElements로 새롭게 구성
            List<Integer> nextElements = new ArrayList<>(elements);
            nextElements.remove(e);

            // prevElements는 기존 값에 현재 엘리먼트 추가 -> 횟수를 거듶할수록 깊이 내려가서 값이 쌓임 = 결과값이 됨
            prevElements.add(e);
            // 재귀 DFS
            dfs(results, prevElements, nextElements);
            // 돌아온 이후에는 prevElements에서 현재 엘리먼트 삭제
            prevElements.remove(e);
        }
    }

    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> results = new ArrayList<>();

        // boxed wrapper
        List<Integer> lst = Arrays.stream(nums).boxed().collect(Collectors.toList());

        dfs(results, new ArrayList<>(), lst);

        return results;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.permute(new int[] { 1, 2, 4 });
    }
}