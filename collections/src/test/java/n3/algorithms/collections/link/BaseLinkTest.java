package n3.algorithms.collections.link;

import java.util.Random;

import static org.testng.Assert.*;

/**
 * @author hzyemao
 * @version 1.0 , 2017/9/9
 */
public class BaseLinkTest {

    protected Node<Integer> buildLink(int length) {
        Node<Integer> head = new Node<>(new Random().nextInt(100), null);
        Node<Integer> node = head;
        for (int i = 0; i < length-1; i++) {
            node.next = new Node<>(new Random().nextInt(100), null);
            node = node.next;
        }
        return head;
    }

    protected void printLink(Node<?> root) {
        if (root == null) {
            return;
        }
        Node<?> node = root;
        while (node != null) {
            System.out.print(node.value);
            node = node.next;
            if (node != null) {
                System.out.print(",");
            }
        }
        System.out.println();
    }

    protected <E extends Comparable<E>> void assertSortAsc(Node<E> head) {
        assertNotNull(head);
        Node<E> node = head;
        while (node.next != null) {
            assertTrue(node.value.compareTo(node.next.value) <= 0);
            node = node.next;
        }
    }

    protected <E extends Comparable<E>> void assertSortDesc(Node<E> head) {
        assertNotNull(head);
        Node<E> node = head;
        while (node.next != null) {
            assertTrue(node.value.compareTo(node.next.value) >= 0);
            node = node.next;
        }
    }
}
