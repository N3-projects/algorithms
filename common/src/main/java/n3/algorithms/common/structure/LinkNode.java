package n3.algorithms.common.structure;

/**
 * @author hzyemao
 * @version 1.0 , 2017/9/12
 */
public class LinkNode extends Node {

    public LinkNode next;

    public LinkNode(Integer value, LinkNode next) {
        super(value);
        this.next = next;
    }
}
