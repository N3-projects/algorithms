package algorithms.leetcode;

import n3.algorithms.fondation.structure.TreeNode;
import n3.algorithms.fondation.tree.TreeTraversal;
import org.testng.annotations.Test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author hzyemao
 * @version 1.0 , 2017/9/12
 */
public class TestL654_MaximumBinaryTree {

    private L654_MaximumBinaryTree maximumBinaryTree = new L654_MaximumBinaryTree();

    @Test
    public void test() {
        int[] a = new int[]{3,2,1,6,0,5};
//        TreeNode root = maximumBinaryTree.constructMaximumBinaryTree(a);
        TreeNode root = constructMaximumBinaryTree(a);

        TreeTraversal.breadthFirstTraversal(root);
    }

    public TreeNode constructMaximumBinaryTree(int[] a) {
        return null;
    }
}
