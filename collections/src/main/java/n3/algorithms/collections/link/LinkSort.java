package n3.algorithms.collections.link;

/**
 * 给定一个无序的链表，请将这个链表排序，返回一个有序的列表
 * @author N3 on 2017/9/6.
 */
public class LinkSort {

    /**
     * 使用冒泡排序算法，交换链表节点value值
     */
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
                    swapNodeValue(temp, temp.next);
                }
                temp = temp.next;
            }
            j = temp;
            i = i.next;
        }
        return root;
    }

    /**
     * 使用归并排序算法，交换链表节点<br>
     * <p>
     * <b>对于链表排序而言，归并排序算法为最佳的排序算法，
     * 既保证了nlogn的时间复杂度，空间复杂度也固定在O(1)，而数组的归并排序空间复杂度为O(n)</b>
     * </p>
     */
    public static Node<Integer> mergeSort(Node<Integer> root) {
        if (root == null) {
            return null;
        }
        if (root.next == null) {
            return root;
        }
        //快慢指针找到中间节点
        Node<Integer> fast = root;  //步长为2
        Node<Integer> slow = root;  //步长为1
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        //此时slow节点即为中间几点，
        Node<Integer> mid = slow.next;  //右边链表的头为slow.next节点
        slow.next = null;   //切断左右两边，链表拆分为2个链表

        Node<Integer> left = mergeSort(root);
        Node<Integer> right = mergeSort(mid);
        return merge(left, right);
    }

    private static Node<Integer> merge(Node<Integer> left, Node<Integer> right) {
        if (left == null) {
            return right;
        } else if (right == null) {
            return left;
        }
        Node<Integer> root ;
        if (left.value <= right.value) {
            root = left;
            left = left.next;
        } else {
            root = right;
            right = right.next;
        }
        Node<Integer> temp = root;
        while (left != null && right != null) {
            if (left.value <= right.value) {
                temp.next = left;
                left = left.next;
            } else {
                temp.next = right;
                right = right.next;
            }
            temp = temp.next;
        }
        //左右两部分有一个已经遍历完了，另一个可能有多余，处理完剩下的节点
        while (left != null) {
            temp.next = left;
            left = left.next;
            temp = temp.next;
        }
        while (right != null) {
            temp.next = right;
            right = right.next;
            temp = temp.next;
        }

        return root;
    }

    /*  快速排序算法-错误示例
    public static Node<Integer> quickSort(Node<Integer> head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node<Integer> low = null;
        Node<Integer> lowTail = null;
        Node<Integer> high = null;
        Node<Integer> highTail = null;
        // 选取头结点作为中枢节点
        Node<Integer> key = head;
        Node<Integer> temp = head.next;
        key.next = null;
        while (temp != null) {
            if (temp.value > key.value) {
                // 比key大的节点加入到高位链表
                if (high == null) {
                    high = temp;
                    highTail = high;
                } else {
                    highTail.next = temp;
                    highTail = highTail.next;
                }
            } else {
                // 比key小的节点加入到低位链表
                if (low == null) {
                    low = temp;
                    lowTail = low;
                } else {
                    lowTail.next = temp;
                    lowTail = lowTail.next;
                }
            }
            temp = temp.next;
        }
        if (lowTail != null) {
            lowTail.next = null;
        }
        if (highTail != null) {
            highTail.next = null;
        }
        low = quickSort(low);
        high = quickSort(high);
        if (low == null) {
            key.next = high;
            return key;
        } else {
            lowTail.next = key;     //问题出在这里，这里的lowTail只是还指向的是low链表在排序前的尾部节点
            key.next = high;
            return low;
        }
    }
    */

    /**
     * 使用快速排序算法
     */
    public static Node<Integer> quickSort(Node<Integer> head) {
        quickSort(head, null);
        return head;
    }

    public static void quickSort(Node<Integer> start, Node<Integer> end) {
        if (start != end && start.next != end) {
            Node<Integer> pivot = partitionLink(start, end);
            quickSort(start, pivot);
            quickSort(pivot.next, end);
        }
    }

    /**
     * 采用同向遍历的快速排序算法，算法交换节点的value值，排序范围为[start, end)左闭右开
     * {@link n3.algorithms.fondation.sort.QuickSort#partitionOneWay_lowAsPartition(int[], int, int)}
     * @return 中枢节点
     */
    private static Node<Integer> partitionLink(Node<Integer> start, Node<Integer> end) {
        if (start == null || start.next == null) {
            return start;
        }
        int key = start.value;
        Node<Integer> low = start;
        Node<Integer> high = start.next;
        while (high != end) {
            if (high.value < key) {
                low = low.next;
                swapNodeValue(low, high);
            }
            high = high.next;
        }
        swapNodeValue(start, low);
        return low;
    }

    private static void swapNodeValue(Node<Integer> n1, Node<Integer> n2) {
        if (n1 != null && n2 != null) {
            int temp = n1.value;
            n1.value = n2.value;
            n2.value = temp;
        }
    }
}
