package algorithms.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <p>
 * 给定一个二叉树，求它的最大深度
 * </p>
 * @author N3 on 2017/7/4.
 */
public class No_104_MaximumDepthOfBinaryTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int x) {
            val = x;
        }
    }

    /**
     * <P> <b>总结：</b><br>
     * 1. 二叉树的遍历，分为深度优先遍历和广度优先遍历（可一行代码解决问题）<br>
     * 2. 深度优先遍历对应递归算法，广度优先遍历对应非递归算法
     * <P> <b>优化：</b><br>
     * 采用非递归算法，避免方法栈溢出
     *
     * @param root 二叉树根节点
     * @return 二叉树最大深度
     * @see <a href="https://leetcode.com/problems/maximum-depth-of-binary-tree">maximum-depth-of-binary-tree</a>
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.addFirst(root);
        int depth = 0;
        while (!stack.isEmpty()) {
            depth++;
            int breadth = stack.size();
            for (int i = 0; i < breadth; i++) {
                TreeNode node = stack.pop();
                if (node.left != null) {
                    stack.addLast(node.left);
                }
                if (node.right != null) {
                    stack.addLast(node.right);
                }
            }
        }
        return depth;
    }
}
