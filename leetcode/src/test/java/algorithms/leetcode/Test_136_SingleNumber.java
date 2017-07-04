package algorithms.leetcode;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author N3 on 2016/11/14.
 */
public class Test_136_SingleNumber {

    private No_136_SingleNumber singleNumber = new No_136_SingleNumber();

    @Test
    public void test() {
        int[] nums = new int[21];
        Assert.assertEquals(singleNumber.singleNumber(nums), singleNumber(nums));
    }

    private int singleNumber(int[] nums) {
        return 0;
    }
}
