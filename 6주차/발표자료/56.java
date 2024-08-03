**문제**

BTS의 각 노드를 자신과 자신보다 더 큰값을 가진 모든 노드의 합으로 만들어라

(이진 탐색 트리(BST)를 누적 합 트리(Greater Sum Tree, GST)로 변환)

[##_Image|kage@cKcnLw/btsIQePnzrO/il2BpjcKLkuVmhDhKiHkOk/img.png|CDM|1.3|{"originWidth":1180,"originHeight":980,"style":"alignLeft","width":518}_##]

[https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/description/](https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/description/)

---

※ **이진 탐색 트리**

이진 탐색이 동작할수 있도록 고안된 효율적인 탐색이 가능한 자료구조

이진 탐색 트리의 특징: **왼쪽 자식 노드<부모 노드<오른쪽 자식 노드**

-   왼쪽 서브트리의 모든 노드 값은 루트 노드 값보다 작습니다.
-   오른쪽 서브트리의 모든 노드 값은 루트 노드 값보다 큽니다.

※ **트리의 순회**

트리 자료구조에 포함된 노드를 특정한 방법으로 한번씩 방문하는 방법을 의미한다.

전위순회: 루트->왼쪽 ->오른쪽

중위순회: 왼쪽->루트->오른쪽

후위순회: 왼쪽->오른쪽->루트

**TreeNode자료구조**

LeetCode에서 제공해주는 TreeNode 클래스는 다음과 같습니다.

```
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
```

```
      6
     / \
    5   7
           \
            8
```

6을 루트로 하는 TreeNode를 작성하기 위해서는

```
TreeNode root = new TreeNode(6);
root.left = new TreeNode(5);
root.right = new TreeNode(7);
root.right.right = new TreeNode(8);
```

위에 코드처럼 붙여줘야함

---

**풀이**

해당 문제는 BST(Binary Search Tree)를 GST(Greater Sum Tree)로 변환하기 위해서 각 노드의 값은 원래의 값에 그보다 **더 큰 값들**을 모두 더한 값이 되어야 합니다. 이를 위해서는 트리의 노드를 역순으로 순회하는 것이 필요합니다. 즉, 노드들을 오른쪽->루트->왼쪽 순으로 순회합니다. 

```
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
```

문제의 이해를 위해 아래 트리구조를 예시로 들겟다.

```
      6
     / \
    5   7
           \
            8
```

1\. bstToGst(6): root는 6인 노드를 가르킴

2.  bstToGst(7)호출 (root.right는 7인 노드를  가르킴)

2-1. bstToGst(7): root는 7인 노드를 가르킴

3\.  bstToGst(8)호출(root.right는 8인 노드를  가르킴)

3-1. bstToGst(8): root는 8인 노드를 가르킴

4.  bstToGst(null)호출 (root.right는 null )

4-1. root=null이 되서 함수는 바로 반환됨

3-2. val 변수에 root값 8이 더해져 **누적합 8.** 

3-3. 현재 node의 값에 val변수 넣음

3-4. bstToGst(null)호출 (root.left는 null )

3-5. root=null이 되서 함수는 바로 반환됨

2-2. val변수에 root값 7이 더해져 **누적합 15.** 

2-3. 현재 node의 값에 val변수 넣음 (8->15)

2-4. bstToGst(null)호출 (root.left는 null )

2-5. root=null이 되서 함수는 바로 반환됨

1-1. val변수에 root값 6이 더해져 **누적합 21.**

1-2. 현재 node의 값에 val변수 넣음(15->21)

1-3 bstToGst(5)호출 (root.left는 5인 노드를 가르킴)

1-4. bstToGst(5): root는 5인 노드를 가르킴

a-1. bstToGst(null)호출 (root.right는 null )

a-2. root=null이 되서 함수는 바로 반환됨

1-5.  val변수에 root값 5이 더해져 **누적합 26.**

1-7. 현재 node의 값에 val변수 넣음(5->26)

| root | val | root값 변화 | 오른쪽 트리 탐색 | 왼쪽 트리 탐색 |
| --- | --- | --- | --- | --- |
| 8 | val=8 | 8->8 | null | null |
| 7 | val=8+7=15 | 7->15 | bstToGst(8) | null |
| 6 | val=15+6=21 | 6->21 | bstToGst(15) | bstToGst(5) |
| 5 | val=21+5=26 | 5->26 | null | null |
