import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int rangeSumBSTDFS(TreeNode root, int low, int high) {
        // 하위 노드 없으면 종료
        if (root == null) {
            return 0;
        }

        // 현재 노드의 값이 high보다 크다면, 오른쪽 서브트리를 탐색할 필요 없음
        if (root.val > high) {
            return rangeSumBST(root.left, low, high);
        }

        // 현재 노드의 값이 low보다 작다면, 왼쪽 서브트리를 탐색할 필요 없음
        if (root.val < low) {
            return rangeSumBST(root.right, low, high);
        }

        // 현재 노드의 값이 [low, high] 범위에 있는 경우:
        // 현재 노드의 값을 더하고, 왼쪽 및 오른쪽 서브트리 모두 탐색
        return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
    }

    public int rangeSumBSTBFS(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }

        int sum = 0;
        Deque<TreeNode> queue = new ArrayDeque<>();
        // BFS는 시작 노드를 미리 큐에 추가하고 탐색 시작.
        queue.add(root);

        while (!queue.isEmpty()) {
            // 최상위 노드부터 탐색 시작
            TreeNode node = queue.poll();

            if (node != null) {
                // 범위 조건 만족하면 합산해서 결과값에 추가
                if (node.val >= low && node.val <= high) {
                    sum += node.val;
                }

                // 현재 노드의 값이 low보다 크다면, 오른쪽 서브트리를 탐색할 필요 없음
                if (node.val > low) {
                    queue.add(node.left);
                }

                // 현재 노드의 값이 high보다 작다면, 왼쪽 서브트리를 탐색할 필요 없음
                if (node.val < high) {
                    queue.add(node.right);
                }
            }
        }
        return sum;
    }
}
