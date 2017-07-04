package algorithms.leetcode;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import algorithms.leetcode.No_104_MaximumDepthOfBinaryTree.TreeNode;

/**
 * @author N3 on 2017/7/4.
 */
public class Test_104_MaximumDepthOfBinaryTree {

    private No_104_MaximumDepthOfBinaryTree maxDepth = new No_104_MaximumDepthOfBinaryTree();
    private TreeNode root = maxDepth.new TreeNode(1);

    @Before
    public void prepare() {
        root.left = maxDepth.new TreeNode(2);
        root.right = maxDepth.new TreeNode(2);

        root.left.left = maxDepth.new TreeNode(3);
        root.left.right = maxDepth.new TreeNode(3);
        root.right.left = maxDepth.new TreeNode(3);
        root.right.right = maxDepth.new TreeNode(3);

        root.right.left.left = maxDepth.new TreeNode(4);
    }

    @Test
    public void test() {
        int maxDepth = this.maxDepth.maxDepth(root);
        Assert.assertEquals(4, maxDepth);
    }

    /**
     * 深度优先遍历
     * @param root
     * @return
     */
    public int depthFirstSearch(TreeNode root) {

        return 0;
    }

    /**
     * 广度优先遍历
     * @param root
     * @return
     */
    public int breadthFirstSearch(TreeNode root) {
        return 0;

    }
}
