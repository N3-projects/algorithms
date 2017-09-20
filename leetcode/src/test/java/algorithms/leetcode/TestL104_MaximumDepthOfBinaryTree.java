package algorithms.leetcode;

import n3.algorithms.common.structure.TreeNode;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author N3 on 2017/7/4.
 */
public class TestL104_MaximumDepthOfBinaryTree {

    private L104_MaximumDepthOfBinaryTree maxDepth = new L104_MaximumDepthOfBinaryTree();
    private TreeNode root = new TreeNode(1);

    @BeforeMethod
    public void prepare() {
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(3);

        root.right.left.left = new TreeNode(4);
    }

    @Test
    public void test() {
        int maxDepth = this.maxDepth.maxDepth(root);
        assertEquals(4, maxDepth);
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
