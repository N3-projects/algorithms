package algorithms.leetcode;

import org.junit.Test;

/**
 * @author N3 on 2017/8/31.
 */
public class Test_535_TinyUrl {

    No_535_TinyUrl tinyUrl = new No_535_TinyUrl();

    @Test
    public void test() {

        String longUrl = "sojdfojwoj2o3f";
        System.out.println(tinyUrl.encode(longUrl));
        System.out.println(tinyUrl.decode(tinyUrl.encode(longUrl)));
    }

    /**
     * 生成短链，主要是方案设计以及进制转换的编码
     * @param longUrl 长链接
     * @return
     */
    public String encode(String longUrl) {
        return null;
    }

    public String decode(String shortUrl) {
        return null;
    }
}
