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
    int prev=Integer.MIN_VALUE+100000;//실제 그 데이터타입이 표현할수있는 숫자의 범위 중 가장작은 숫자
    int minDiff=Integer.MAX_VALUE;//오버플로 방지
    public int minDiffInBST(TreeNode root) {
        //왼쪽 자식 노드 맨 아래까지 탐색
        if(root.left!=null) minDiffInBST(root.left);

        //현재 노드 값(root.val)과 이전 노드값(prev)의 차이를 구하고
        // 그값이 현재 minDiff보다 작으면 업데이트
        minDiff=Math.min(minDiff,root.val-prev);

        //현재 노드값을 이전 노드값으로 설정하여 다음노드의 차이를 계산할때 사용
        prev=root.val;

        //오른쪽 자식 노드 재귀 탐색
        if(root.right!=null)minDiffInBST(root.right);

        //최솟값을 결과로 리턴
        return minDiff;

    }
}