class Solution {
    int sum = 0;
    public TreeNode bstToGst(TreeNode root) {
        if (root != null) {
            // 오른쪽 노드부터 반대로 탐색 -> 역순 중위 순회(Reverse In-Order Traversal)
            bstToGst(root.right);
            // 현재 노드 값 추가 -> 현재 노드보다 큰 값의 합계가 됨.
            sum += root.val;
            root.val = sum;

            // 왼쪽 노드 탐색 -> 이미 더 큰 값들을 모두 처리했으므로 왼쪽에서 재귀돌리면 똑같이 수행 가능.
            bstToGst(root.left);
        }
        return root;
    }
}
