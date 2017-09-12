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

        Deque<TreeNode> stack = new LinkedList<>();
        for (int i = 0; i < a.length; i++) {
            TreeNode node = new TreeNode(a[i]);
            while (!stack.isEmpty() && stack.peekLast().value < node.value) {
                TreeNode tail = stack.pollLast();
                node.left = tail;
            }
            if (!stack.isEmpty()) {
                stack.peekLast().right = node;
            }
            stack.add(node);
        }
        return stack.peekFirst();
    }
}
