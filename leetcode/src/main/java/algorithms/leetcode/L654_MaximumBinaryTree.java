package algorithms.leetcode;

import n3.algorithms.fondation.structure.TreeNode;

import java.util.LinkedList;

/**
 * <p>给定一个不重复的int数组，根据这个数组构建一个如下规则的“最大树”：<br>
 * 1. 根节点是数组中最大的整数
 * 2. 左子树是由数组中最大整数左半部分的数组构造而成的“最大树”
 * 3. 右子树是由数组中最大整数左半部分的数组构造而成的“最大树”
 * <p>写一根据指定的数组构造这种“最大树”并输出它。
 * <p>Note：原数组的大小范围在1-1000之内。
 *
 * @author N3 on 2016/11/14.
 */
public class L654_MaximumBinaryTree {

    /**
     * <P> <b>总结：</b><br>
     * 1. 最容易想到的是递归算法实现，且原定义条件中有说明数组大小在1000以内，不会有栈溢出的问题
     * <P> <b>优化：</b><br>
     * 采用非递归算法，需要仔细思考下这种二叉树构建的特点<br>
     * 遍历数组插入到二叉树中，当新插入的节点比之前的根节点大时该当如何，比之前的根节点小时又该当如何
     *
     * @param n 石头总个数
     * @return 先手是否可以必胜
     * @see <a href="https://leetcode.com/problems/maximum-binary-tree">maximum-binary-tree</a>
     */
    public TreeNode constructMaximumBinaryTree(int[] nums) {

        if (nums == null || nums.length == 0) {
            return null;
        }

        return constructInternal(nums, 0, nums.length - 1);
    }

    private TreeNode constructInternal(int[] nums, int start, int end) {
        if (start == end) {
            return new TreeNode(nums[start]);
        }
        Integer maxNum = null;
        int index = start;
        for (int i = start; i <= end; i++) {
            if (maxNum == null || nums[i] > maxNum) {
                maxNum = nums[i];
                index = i;
            }
        }
        TreeNode root = new TreeNode(maxNum);
        if (start <= index - 1) {
            root.left = constructInternal(nums, start, index - 1);
        }
        if (index + 1 <= end) {
            root.right = constructInternal(nums, index + 1, end);
        }
        return root;
    }

    public TreeNode constructMaximumBinaryTreeNonRecursive(int[] nums) {

        if (nums == null || nums.length == 0) {
            return null;
        }
        LinkedList<TreeNode> stack = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            TreeNode cur = new TreeNode(nums[i]);
            while (!stack.isEmpty() && stack.peekLast().value < nums[i]) {
                cur.left = stack.pollLast();
            }
            if (!stack.isEmpty()) {
                stack.peekLast().right = cur;
            }
            stack.addLast(cur);
        }
        return stack.getFirst();
    }
}
