package algorithms.leetcode;

import java.util.Deque;
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
//        return depthFirstSearch(root);
        return breadthFirstSearch(root);
    }

    /**
     * 深度优先遍历
     * @param root
     * @return
     */
    private int depthFirstSearch(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        Deque<Integer> depthStack = new LinkedList<>();
        int depth = 1;
        stack.offer(root);
        depthStack.offer(depth);
        int maxDepth = depth;
        while (!stack.isEmpty()) {
            TreeNode node = stack.poll();
            depth = depthStack.poll();
            maxDepth = depth>maxDepth ? depth : maxDepth;
            if (node != null) {
                if (node.left != null) {
                    stack.offer(node.left);
                    depthStack.offer(depth+1);
                }
                if (node.right != null) {
                    stack.offer(node.right);
                    depthStack.offer(depth+1);
                }
            }
        }
        return maxDepth;
    }

    /**
     * 广度优先遍历
     * @param root
     * @return
     */
    private int breadthFirstSearch(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            depth++;
            int breadth = queue.size();
            for (int i = 0; i < breadth; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return depth;
    }
}
