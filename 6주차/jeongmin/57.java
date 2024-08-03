/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root==null) return 0;
        //노드 값이 high보다 크면 더작아야하므로 왼쪽 노드 탐색
        if(root.val>high) return rangeSumBST(root.left,low,high);
        //노드값이 low보다 작으면 더 커야므로 오른쪽 노드 탐색
        if(root.val<low) return rangeSumBST(root.right,low,high);
        //여기까지 도달한거면 노드값이ㅣ low와 high범위내에 있으므로,모든 결과를 합산하여 리턴
        return root.val+rangeSumBST(root.left,low,high)+rangeSumBST(root.right,low,high);
    }
}