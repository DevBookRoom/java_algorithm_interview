<p data-ke-size="size16"><b>문제</b></p>
<p data-ke-size="size16">BTS의 각 노드를 자신과 자신보다 더 큰값을 가진 모든 노드의 합으로 만들어라<b></b></p>
<p data-ke-size="size16">(이진 탐색 트리(BST)를 누적 합 트리(Greater Sum Tree, GST)로 변환)</p>
<p>[##_Image|kage@cKcnLw/btsIQePnzrO/il2BpjcKLkuVmhDhKiHkOk/img.png|CDM|1.3|{"originWidth":1180,"originHeight":980,"style":"alignLeft","width":518}_##]</p>
<p data-ke-size="size16"><a href="https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/description/" target="_blank" rel="noopener&nbsp;noreferrer">https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/description/</a></p>
<hr contenteditable="false" data-ke-style="style5" data-ke-type="horizontalRule" />
<p data-ke-size="size16"><span style="background-color: #ffffff; color: #222222; text-align: left;">※</span><b><span> </span></b><b><span>이진 탐색 트리</span></b></p>
<p data-ke-size="size16"><span>이진 탐색이 동작할수 있도록 고안된 효율적인 탐색이 가능한 자료구조</span></p>
<p data-ke-size="size16"><span>이진 탐색 트리의 특징: <b><span style="background-color: #f3c000;">왼쪽 자식 노드&lt;부모 노드&lt;오른쪽 자식 노드</span></b></span></p>
<ul style="list-style-type: disc;" data-ke-list-type="disc">
<li>왼쪽 서브트리의 모든 노드 값은 루트 노드 값보다 작습니다.</li>
<li>오른쪽 서브트리의 모든 노드 값은 루트 노드 값보다 큽니다.</li>
</ul>
<p data-ke-size="size16"><span><span style="background-color: #ffffff; color: #222222; text-align: left;">※ </span></span><b><span>트리의 순회</span></b></p>
<p data-ke-size="size16"><span>트리 자료구조에 포함된 노드를 특정한 방법으로 한번씩 방문하는 방법을 의미한다.</span></p>
<p data-ke-size="size16"><span>전위순회: 루트-&gt;왼쪽 -&gt;오른쪽</span></p>
<p data-ke-size="size16"><span>중위순회: 왼쪽-&gt;루트-&gt;오른쪽</span></p>
<p data-ke-size="size16"><span>후위순회: 왼쪽-&gt;오른쪽-&gt;루트</span></p>
<p data-ke-size="size16">&nbsp;</p>
<p data-ke-size="size16"><b>TreeNode자료구조</b></p>
<p data-ke-size="size16"><span style="color: #000000; text-align: start;">LeetCode에서 제공해주는 TreeNode 클래스는 다음과 같습니다.</span></p>
<pre id="code_1722421024134" class="java" data-ke-language="java" data-ke-type="codeblock"><code>	/**
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
 */</code></pre>
<p data-ke-size="size16">&nbsp;</p>
<p data-ke-size="size16">&nbsp;</p>
<pre id="code_1722421465388" class="java" data-ke-language="java" data-ke-type="codeblock"><code>      6
     / \
    5   7
           \
            8</code></pre>
<p data-ke-size="size16">6을 루트로 하는 TreeNode를 작성하기 위해서는</p>
<pre id="code_1722342220360" class="java" data-ke-language="java" data-ke-type="codeblock"><code>TreeNode root = new TreeNode(6);
root.left = new TreeNode(5);
root.right = new TreeNode(7);
root.right.right = new TreeNode(8);</code></pre>
<p data-ke-size="size16">위에 코드처럼 붙여줘야함</p>
<hr contenteditable="false" data-ke-style="style5" data-ke-type="horizontalRule" />
<p data-ke-size="size16"><b>풀이</b></p>
<p data-ke-size="size16">해당 문제는 BST(Binary Search Tree)를 GST(Greater Sum Tree)로 변환하기 위해서 각 노드의 값은 원래의 값에 그보다 <b>더 큰 값들</b>을 모두 더한 값이 되어야 합니다. 이를 위해서는 트리의 노드를 역순으로 순회하는 것이 필요합니다. 즉, 노드들을 오른쪽-&gt;루트-&gt;왼쪽 순으로 순회합니다.&nbsp;</p>
<pre id="code_1719232023936" class="java" data-ke-language="java" data-ke-type="codeblock"><code>class Solution {
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
}</code></pre>
<p data-ke-size="size16">문제의 이해를 위해 아래 트리구조를 예시로 들겟다.</p>
<pre id="code_1722597017940" class="java" data-ke-language="java" data-ke-type="codeblock"><code>      6
     / \
    5   7
           \
            8</code></pre>
<p data-ke-size="size16">1. bstToGst(6): root는 6인 노드를 가르킴</p>
<p data-ke-size="size16">&nbsp;</p>
<p data-ke-size="size16">2.&nbsp; <span style="background-color: #f3c000;">bstToGst(7)호출</span> (root.right는 7인 노드를&nbsp; 가르킴)</p>
<p data-ke-size="size16">2-1. bstToGst(7): root는 7인 노드를 가르킴</p>
<p data-ke-size="size16">&nbsp;</p>
<p data-ke-size="size16">3. <span style="color: #333333; text-align: start;"><span>&nbsp;</span></span><span style="background-color: #f3c000;">bstToGst(8)호출</span>(root.right는 8인 노드를&nbsp; 가르킴)</p>
<p data-ke-size="size16">3-1. bstToGst(8):<span>&nbsp;</span>root는 8인 노드를 가르킴</p>
<p style="color: #333333; text-align: start;" data-ke-size="size16">&nbsp;</p>
<p style="color: #333333; text-align: start;" data-ke-size="size16">4.<span> </span><span style="color: #333333; text-align: start;"><span>&nbsp;</span></span><span style="background-color: #f3c000;">bstToGst(null)호출</span> (root.right는 null )</p>
<p style="color: #333333; text-align: start;" data-ke-size="size16">4-1. root=null이 되서 함수는 바로 반환됨</p>
<p style="color: #333333; text-align: start;" data-ke-size="size16">&nbsp;</p>
<p style="color: #333333; text-align: start;" data-ke-size="size16">3-2. val 변수에 root값 8이<span style="color: #333333; text-align: start;"><span>&nbsp;</span>더해져 <b>누적합 8.&nbsp;</b></span></p>
<p style="color: #333333; text-align: start;" data-ke-size="size16">3-3. 현재 node의 값에 val변수 넣음</p>
<p style="color: #333333; text-align: start;" data-ke-size="size16">3-4. bstToGst(null)호출 (root.left는 null )</p>
<p style="color: #333333; text-align: start;" data-ke-size="size16">3-5. root=null이 되서 함수는 바로 반환됨</p>
<p style="color: #333333; text-align: start;" data-ke-size="size16">&nbsp;</p>
<p style="color: #333333; text-align: start;" data-ke-size="size16">2-2. val변수에 root값 7이 더해져 <b>누적합 15.&nbsp;</b></p>
<p style="color: #333333; text-align: start;" data-ke-size="size16">2-3. 현재 node의 값에 val변수 넣음 (8-&gt;15)</p>
<p style="color: #333333; text-align: start;" data-ke-size="size16">2-4. bstToGst(null)호출<span>&nbsp;</span>(root.left는 null )</p>
<p style="color: #333333; text-align: start;" data-ke-size="size16">2-5. root=null이 되서 함수는 바로 반환됨</p>
<p style="color: #333333; text-align: start;" data-ke-size="size16">&nbsp;</p>
<p style="color: #333333; text-align: start;" data-ke-size="size16">1-1. val변수에 root값 6이 더해져 <b>누적합 21.</b></p>
<p style="color: #333333; text-align: start;" data-ke-size="size16">1-2. 현재 node의 값에 val변수 넣음(15-&gt;21)</p>
<p style="color: #333333; text-align: start;" data-ke-size="size16">&nbsp;</p>
<p style="color: #333333; text-align: start;" data-ke-size="size16">1-3 bstToGst(5)호출<span>&nbsp;</span>(root.left는 5인 노드를 가르킴)</p>
<p style="color: #333333; text-align: start;" data-ke-size="size16">1-4. bstToGst(5): root는 5인 노드를 가르킴</p>
<p style="color: #333333; text-align: start;" data-ke-size="size16"><span style="color: #333333; text-align: start;">a-1. </span>bstToGst(null)호출&nbsp;(root.right는 null )</p>
<p style="color: #333333; text-align: start;" data-ke-size="size16">a-2. root=null이 되서 함수는 바로 반환됨</p>
<p style="color: #333333; text-align: start;" data-ke-size="size16">1-5.&nbsp; <span style="color: #333333; text-align: start;">val변수에 root값 5이 더해져<span>&nbsp;</span></span><b>누적합 26.</b></p>
<p style="color: #333333; text-align: start;" data-ke-size="size16">1-7. 현재 node의 값에 val변수 넣음(5-&gt;26)</p>
<table style="border-collapse: collapse; width: 88.1395%; height: 87px;" border="1" data-ke-align="alignLeft">
<tbody>
<tr style="height: 19px;">
<td style="width: 4.65116%; height: 19px;">root</td>
<td style="width: 10.4263%; height: 19px;">val</td>
<td style="width: 9.6511%; height: 19px;">root값 변화</td>
<td style="width: 11.6473%; height: 19px;">오른쪽 트리 탐색</td>
<td style="width: 11.3803%; height: 19px;">왼쪽 트리 탐색</td>
</tr>
<tr style="height: 17px;">
<td style="width: 4.65116%; height: 17px;">8</td>
<td style="width: 10.4263%; height: 17px;">val=8</td>
<td style="width: 9.6511%; height: 17px;">8-&gt;8</td>
<td style="width: 11.6473%; height: 17px;">null</td>
<td style="width: 11.3803%; height: 17px;">null</td>
</tr>
<tr style="height: 17px;">
<td style="width: 4.65116%; height: 17px;">7</td>
<td style="width: 10.4263%; height: 17px;">val=8+7=15</td>
<td style="width: 9.6511%; height: 17px;">7-&gt;15</td>
<td style="width: 11.6473%; height: 17px;">bstToGst(8)</td>
<td style="width: 11.3803%; height: 17px;">null</td>
</tr>
<tr style="height: 17px;">
<td style="width: 4.65116%; height: 17px;">6</td>
<td style="width: 10.4263%; height: 17px;">val=15+6=21</td>
<td style="width: 9.6511%; height: 17px;">6-&gt;21</td>
<td style="width: 11.6473%; height: 17px;">bstToGst(15)</td>
<td style="width: 11.3803%; height: 17px;">bstToGst(5)</td>
</tr>
<tr style="height: 17px;">
<td style="width: 4.65116%; height: 17px;">5</td>
<td style="width: 10.4263%; height: 17px;">val=21+5=26</td>
<td style="width: 9.6511%; height: 17px;">5-&gt;26</td>
<td style="width: 11.6473%; height: 17px;">null</td>
<td style="width: 11.3803%; height: 17px;">null</td>
</tr>
</tbody>
</table>
<p data-ke-size="size16">&nbsp;</p>
<p data-ke-size="size16">&nbsp;</p>
<p data-ke-size="size16">&nbsp;</p>
