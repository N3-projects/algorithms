package n3.algorithms.fondation.tree;

import n3.algorithms.common.structure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author hzyemao
 * @version 1.0 , 2017/9/12
 */
public class TreeTraversal {

    /**
     * 中序遍历，即中根遍历，先访问左子树，再访问根节点，再访问右子树
     * @param root
     */
    public static void InOrderTraversal(TreeNode root) {

    }

    /**
     * 前序遍历，即先根遍历，先访问根节点，再访问左子树，再访问右子树
     * @param root
     */
    public static void preOrderTraversal(TreeNode root) {

    }

    /**
     * 后序遍历，即后根遍历，先访问左子树，再访问右子树，最后访问根节点
     * @param root
     */
    public static void postOrderTraversal(TreeNode root) {

    }

    /**
     * 广度优先遍历
     * @param root
     */
    public static void breadthFirstTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.println(node.value);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }

    /**
     * 深度优先遍历
     * @param root
     */
    public static void depthFirstTraversal(TreeNode root) {

    }

}
