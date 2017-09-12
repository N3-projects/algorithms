package algorithms.leetcode;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author N3 on 2016/11/14.
 */
public class TestL136_SingleNumber {

    private L136_SingleNumber singleNumber = new L136_SingleNumber();

    @Test
    public void test() {
        int[] nums = new int[21];
        assertEquals(singleNumber.singleNumber(nums), singleNumber(nums));
    }

    private int singleNumber(int[] nums) {
        return 0;
    }
}
