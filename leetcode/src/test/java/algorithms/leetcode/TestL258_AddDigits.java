package algorithms.leetcode;

import org.testng.annotations.Test;

import java.util.Random;

import static org.testng.Assert.assertEquals;

/**
 * @author N3 on 2016/11/14.
 */
public class TestL258_AddDigits {

    private L258_AddDigits addDigits = new L258_AddDigits();

    @Test
    public void test() {
        int num = new Random().nextInt();
        assertEquals(addDigits.addDigits(num), addDigits(num));
    }

    private  int addDigits(int num) {
        return 0;
    }
}
