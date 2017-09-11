package n3.algorithms.collections.link;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * @author N3 on 2017/9/6.
 */
public class TestLinkSort extends BaseLinkTest{

    private Node<Integer> root;

    @BeforeMethod
    public void prepare() {
        int length = 7;
        root = buildLink(length);
        printLink(root);
    }

    @Test
    public void testBubbleSort() {
        Node<Integer> resultRoot = LinkSort.bubbleSort(root);
        printLink(resultRoot);

        assertSortAsc(resultRoot);
    }

    @Test
    public void testMergeSort() {
        Node<Integer> resultRoot = LinkSort.mergeSort(root);
        printLink(resultRoot);

        assertSortAsc(resultRoot);
    }

    @Test
    public void testQuickSort() {
        Node<Integer> resultRoot = LinkSort.quickSort(root);
        printLink(resultRoot);

        assertSortAsc(resultRoot);
    }
}
