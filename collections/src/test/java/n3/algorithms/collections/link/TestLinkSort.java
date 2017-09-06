package n3.algorithms.collections.link;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Random;

/**
 * @author N3 on 2017/9/6.
 */
public class TestLinkSort {

    private Node<Integer> root = new Node<>(new Random().nextInt(100), null);
    private int size = 16;

    @BeforeTest
    public void prepare() {
        Node node = root;
        for (int i = 0; i < size-1; i++) {
            node.next = new Node<>(new Random().nextInt(100), null);
            node = node.next;
        }
        printLink(root);
    }

    private void printLink(Node root) {
        if (root == null) {
            return;
        }
        Node node = root;
        while (node != null) {
            System.out.print(node.value);
            node = node.next;
            if (node != null) {
                System.out.print(",");
            }
        }
        System.out.println();
    }

    @Test
    public void testBubbleSort() {
        Node<Integer> resultRoot = LinkSort.bubbleSort(root);
        printLink(resultRoot);

        Node<Integer> node = resultRoot;
        while (node.next != null) {
            Assert.assertTrue(node.value < node.next.value);
            node = node.next;
        }
    }
}
