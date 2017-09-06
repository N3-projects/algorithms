package n3.algorithms.collections.link;

/**
 * @author N3 on 2017/9/6.
 */
class Node<E> {

    public E value;
    public Node<E> next;

    public Node(E value, Node<E> next) {
        this.value = value;
        this.next = next;
    }
}
