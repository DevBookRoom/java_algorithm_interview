public class Solution {
    public TreeNode dfs(int preIndex, int inStart, int inEnd, int[] preorder, int[] inorder) {
        // 예외 처리
        if (preIndex > preorder.length - 1 || inStart > inEnd) return null;

        // 전위 순회 값이 중위 순회에서는 몇 번째 인덱스인지 추출
        int inIndex = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == preorder[preIndex]) {
                inIndex = i;
                break;
            }
        }

        TreeNode node = new TreeNode(preorder[preIndex]); // 노드 값은 preorder에서 가져와야 합니다
        preIndex++;
        node.left = dfs(preIndex, inStart, inIndex - 1, preorder, inorder);
        node.right = dfs(preIndex + inIndex - inStart, inIndex + 1, inEnd, preorder, inorder);

        return node; // 반환 값을 명시합니다
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return dfs(0, 0, inorder.length - 1, preorder, inorder);
    }
}
