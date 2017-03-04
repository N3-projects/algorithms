package algorithms.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.Random;

/**
 * @author N3 on 2016/11/14.
 */
public class Test_136_SingleNumber {

    private _136_SingleNumber singleNumber = new _136_SingleNumber();

    @Test
    public void test() {
        int[] nums = new int[21];
        Assert.assertEquals(singleNumber.singleNumber(nums), singleNumber(nums));
    }

    private int singleNumber(int[] nums) {
        return 0;
    }
}
