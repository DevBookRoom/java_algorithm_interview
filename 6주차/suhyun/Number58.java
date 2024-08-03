class Solution {

    // 이전의 노드값
    int prev = Integer.MIN_VALUE + 100000;
    // 노드간의 최솟값
    int minDiff = Integer.MAX_VALUE;

    public int minDiffInBST(TreeNode root) {

        // 루트의 왼쪽값이 있는 경우 무조건 좌측 이동
        if (root.left != null) {
            minDiffInBST(root.left);
        }
        // 지금 값과 이전 값 비교해보기
        minDiff = Math.min(minDiff, root.val - prev);
        // 현재 값을 이전 노드값으로 변경
        prev = root.val;

        if (root.right != null) {
            minDiffInBST(root.right);
        }

        return minDiff;
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
