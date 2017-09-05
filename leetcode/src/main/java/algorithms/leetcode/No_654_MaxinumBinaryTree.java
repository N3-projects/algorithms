package algorithms.leetcode;

import java.util.LinkedList;

/**
 * <p>给定一个不重复的int数组，根据这个数组构建一个如下规则的“最大树”：<br>
 * 1. 根节点是数组中最大的整数
 * 2. 左子树是由数组中最大整数左半部分的数组构造而成的“最大树”
 * 3. 右子树是由数组中最大整数左半部分的数组构造而成的“最大树”
 * <p>写一根据指定的数组构造这种“最大树”并输出它。
 *
 * @author N3 on 2016/11/14.
 */
public class No_654_MaxinumBinaryTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * <P> <b>总结：</b><br>
     * 1. 通过简单枚举找到规律（可一行代码解决问题）<br>
     * 2. 除了枚举发现规律外，按正常逻辑，算法可关联斐波那契数列
     * <P> <b>优化：</b><br>
     * 采用非递归算法，降低复杂度
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

    public TreeNode constructMaximumBinaryTree_nlogn(int[] nums) {

        if (nums == null || nums.length == 0) {
            return null;
        }
        LinkedList<TreeNode> stack = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            TreeNode cur = new TreeNode(nums[i]);
            while (!stack.isEmpty() && stack.peekLast().val < nums[i]) {
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
