package n3.algorithms.collections.link;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * @author N3 on 2017/9/6.
 */
public class TestLinkSort extends BaseLinkTest{

    private Node<Integer> root;

    @BeforeMethod
    public void prepare() {
        int length = 5;
        root = buildLink(length);
        printLink(root);
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

    @Test
    public void testMergeSort() {
        Node<Integer> resultRoot = LinkSort.mergeSort(root);
        printLink(resultRoot);

        assertSortAsc(resultRoot);
    }
}
