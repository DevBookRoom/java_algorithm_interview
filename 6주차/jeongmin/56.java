
class Solution {
    public TreeNode bstToGst(TreeNode root) {

        if(root!=null){
            //오른쪽 자식 노드부터 탐색
            bstToGst(root.right);
            //누적된 값에 현재 노드값 추가
            val+=root.val;
            //현재 노드값을 지금까지 누적된 값으로 할당
            root.val=val;
            //왼쪽자식노드탐색
            bstToGst(root.left);
        }
        return root;
    }
}