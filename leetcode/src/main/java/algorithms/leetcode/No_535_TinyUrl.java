package algorithms.leetcode;

import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * <p>
 * 设计一个简单的短链服务，给定一个长url链接可生成一个短链，输入短链时可得到原链接
 * </p>
 * @author N3 on 2017/8/30.
 */
public class No_535_TinyUrl {

    private AtomicLong seq = new AtomicLong(64*64*64);  //起始长度为4位短链
    private ConcurrentHashMap<String, String> short2Long = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, String> long2Short = new ConcurrentHashMap<>();
    private static char[] charSet = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".toCharArray();

    /**
     * <P> <b>总结：</b><br>
     * 1. 最容易想到的是hash算法，但无法避免的就有hash冲突问题<br>
     * 2. 生成的短链结果由0-9A-Za-z组成，可看做一个62进制数<br>
     *     因而可维护一个全局自增长的10进制->62进制序列，每次获取时只需要序列号+1即可
     * 3. 要通过短链找回长链，很容易想到用一个Map来实现<br>
     * <P> <b>优化：</b><br>
     * 1. 由于我们采用序列自增长的方式实现，会导致同一个长链重复获取时会生成不同的短链
     *     为了解决这个问题，可以再维护一个key为长链，value为短链的Map，每次生成前先检查此长链是否有已经生成的短链存在
     * 4. 实际生产中，应为中间件缓存的序列和Map
     *
     * @param longUrl 长连接
     * @return 短链接
     * @see <a href="https://leetcode.com/problems/encode-and-decode-tinyurl">encode-and-decode-tinyurl</a>
     * @see <a href="http://www.jianshu.com/p/d1cb7a51e7e5">短网址服务系统如何设计</a>
     */
    public String encode(String longUrl) {
        // Encodes a URL to a shortened URL.
        String shortUrl = long2Short.get(longUrl);
        if (shortUrl != null)
        {
            return shortUrl;
        }
        shortUrl = to62String(seq.getAndIncrement());
        short2Long.put(shortUrl, longUrl);
        long2Short.put(longUrl, shortUrl);
        return shortUrl;
    }

    public String decode(String shortUrl) {
        // Decodes a shortened URL to its original URL.
        return short2Long.get(shortUrl);
    }

    private static String to62String(long number) {
        LinkedList<Character> stack = new LinkedList<>();
        long rest = number;
        while (rest != 0) {
            stack.add(charSet[new Long(rest-(rest/62)*62).intValue()]);
            rest = rest/62;
        }
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty())
        {
            result.append(stack.removeLast());
        }
        return result.toString();
    }
}
