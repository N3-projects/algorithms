package algorithms.leetcode;

import n3.algorithms.common.structure.TreeNode;
import n3.algorithms.common.tag.KeyIdea;
import n3.algorithms.common.tag.Tag;

/**
 * <p>
 * 合并两个二叉树，合并规则是如果两个节点重叠，则sum节点值作为合并节点的新值。<br>
 * 否则，非空节点将被用作新树的节点，得到新的二叉树对应位置上的节点；若两个树在相同位置上的节点都为空，则新树的该节点也为空。
 * </p>
 *
 * @author hzyemao
 * @version 1.0 , 2017/9/20
 */
public class L617_MergeTwoBinaryTree {

    @Tag(KeyIdea.递归)
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return null;
        }
        TreeNode newNode = new TreeNode((t1 == null ? 0 : t1.value) + (t2 == null ? 0 : t2.value));
        newNode.left = mergeTrees(t1 == null ? null : t1.left, t2 == null ? null : t2.left);
        newNode.right = mergeTrees(t1 == null ? null : t1.right, t2 == null ? null : t2.right);
        return newNode;
    }
}
