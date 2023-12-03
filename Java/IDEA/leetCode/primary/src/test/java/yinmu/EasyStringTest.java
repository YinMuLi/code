package yinmu;

import junit.framework.TestCase;

/**
 * @author 饮木
 * @Date 2022/6/24
 * @Description description
 */
public class EasyStringTest extends TestCase {

    public void testReverseString() {
        char[] test = {'h', 'e', 'l', 'l', 'o'};
        EasyString.reverseString(test);
    }

    public void testReverse() {
        System.out.println(EasyString.reverse(1534236469));
    }

    public void testFirstUniqChar() {
        System.out.println(EasyString.firstUniqChar("opppij"));
    }

    public void testIsAnagram() {
        System.out.println(EasyString.isAnagram("a", "ab"));
    }

    public void testMyAtoi() {
        System.out.println(EasyString.myAtoi("9223372036854775808"));
    }

    public void testStrStr() {
        System.out.println(EasyString.strStr("mississippi", "issipi"));
    }

    public void testCountAndSay() {
        System.out.println(EasyString.countAndSay(5));
    }
}