package n3.algorithms.collections.link;

/**
 * 给定一个无序的链表，请将这个链表排序，返回一个有序的列表
 * @author N3 on 2017/9/6.
 */
public class LinkSort {

    public static Node<Integer> bubbleSort(Node<Integer> root) {
        if (root == null) {
            return null;
        }
        Node<Integer> i = root;
        Node<Integer> j = null;
        while (i.next != null) {
            Node<Integer> temp = root;
            while(temp.next != j) {
                if(temp.value > temp.next.value) {
                    Integer value = temp.value;
                    temp.value = temp.next.value;
                    temp.next.value = value;
                }
                temp = temp.next;
            }
            j = temp;
            i = i.next;
        }
        return root;
    }

}
