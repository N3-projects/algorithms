package algorithms.leetcode;

/**
 * <p>
 * 有一个int型的数组，其中所有的数字都出现了2次，仅有一个数只出现了一次，请找出这个唯一的数字。
 * </p>
 * <p>
 * 算法尽量不要使用额外的内存空间。
 * </p>
 *
 * @author N3 on 2017/2/14.
 */
public class L136_SingleNumber {

    /**
     * <p>
     * <b>异或：</b><br>
     * 异或是一种基于二进制的位运算，用符号XOR或者 ^ 表示，其运算法则是对运算符两侧数的每一个二进制位，同值取0，异值取1。
     * 它与布尔运算的区别在于，当运算符两侧均为1时，布尔运算的结果为1，异或运算的结果为0（相同为0不同为1）<br>
     * </p>
     * <p>
     * <b>性质：</b><br>
     * 1. 交换律 a ^ b = b ^ a <br>
     * 2. 结合律 (a ^ b) ^ c = a ^ (b ^ c) <br>
     * 3. 对于任何数x，都有x ^ x = 0，x ^ 0 = x <br>
     * 4. 自反性 a ^ b ^ b = a ^ 0 = a <br>
     * </p>
     * <p>
     * <b>总结：</b><br>
     * n个数，存在明显的相同或不同的特征的时候，可以考虑使用异或运算，尤其结合上述性质的2、3条，
     * 且只需要对异或结果作比较，无需额外的内存空间。
     * </p>
     *
     * @param nums 整数数组
     * @return 只出现一次的那个数字
     */
    public int singleNumber(int[] nums) {
        int single = 0;
        for (int i = 0; i < nums.length; i++) {
            single ^= nums[i];
        }
        return single;
    }
}
