package yinmu;

/**
 * @author 饮木
 * @Date 2022/6/24
 * @Description description
 */
public class EasyString {
    private EasyString() {
    }

    /**
     * 反转字符串
     *
     * @param s 字符数组
     */
    public static void reverseString(char[] s) {
        char temp;
        int length = s.length;
        for (int i = 0; i < length / 2; i++) {
            temp = s[i];
            s[i] = s[length - 1 - i];
            s[length - 1 - i] = temp;
        }
    }

    /**
     * 整数反转
     *
     * @param x -2^31 <= x <= 2^31 - 1
     * @return 反转后的数字
     */
    public static int reverse(int x) {
        long result = 0;
        //判断x的正负性
        boolean flag = x >= 0;
        //取x绝对值
        x = Math.abs(x);
        while (x != 0) {
            result = result * 10 + x % 10;
            //判断越界问题
            if (result < Integer.MIN_VALUE || result > Integer.MAX_VALUE) {
                return 0;
            }
            x /= 10;
        }

        return (int) (flag ? result : (-result));
    }

    /**
     * 字符串中的第一个唯一字符
     *
     * @param s 原字符串
     * @return 存在返回其下标，否则就返回-1
     */
    public static int firstUniqChar(String s) {
        //自制map
        int length = s.length();
        //26个字母
        //value:1表示该字符串纯在该字符,且只出现一次，0表示不存在,2表示重复出现
        int[] value = new int[26];
        //key数组的最后以为记录最小的下标
        int[] key = new int[26];
        //字符的下标
        int index;
        for (int i = 0; i < length; i++) {
            //s中都是小写字母
            index = s.charAt(i) - 'a';
            value[index]++;
            key[index] = i;
        }
        for (int i = 0; i < length; i++) {
            index = s.charAt(i) - 'a';
            if (value[index] == 1) {
                return key[index];
            }
        }
        return -1;
    }

    /**
     * 有效的字母异位词
     *
     * @param s 字符串
     * @param t 字符串
     * @return s中字母出现的次数和t中字母出现的次数一样返回true，否则返回false
     */
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            //长度不相等肯定字谜出现的次数不一样
            return false;
        }
        //都是小写字母
        int[] value = new int[26];
        //遍历字符串s
        for (int i = 0; i < s.length(); i++) {
            value[s.charAt(i) - 'a']++;
            value[t.charAt(i) - 'a']--;
        }
        for (int j : value) {
            if (j != 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 验证回文串
     *
     * @param s 字符串
     * @return true：是回文串；false不是
     */
    public static boolean isPalindrome(String s) {
        //双指针
        int length = s.length();
        //指向头
        int head = 0;
        //指向尾
        int end = length - 1;
        while (head < end) {
            //传入的字符串中有空格和标点符号，
            //判断两个字母是否相等（忽略大小写）
            //先去除不是数字和字母的情况
            if (!Character.isLetterOrDigit(s.charAt(head))) {
                head++;
                continue;
            }
            if (!Character.isLetterOrDigit(s.charAt(end))) {
                end--;
                continue;
            }
            if (Character.toLowerCase(s.charAt(head)) != Character.toLowerCase(s.charAt(end))) {
                return false;
            }
            head++;
            end--;
        }
        return true;
    }

    /**
     * 字符串转换整数 (atoi)
     *
     * @param s 原字符串
     * @return 返回整数作为最终结果
     */
    public static int myAtoi(String s) {
        int result = 0;
        //判断s中是否存在符号
        boolean flag = false;
        //先去除s中的前导空格
        int i = 0;
        while (i < s.length() && s.charAt(i) == ' ') {
            i++;
        }
        if (i == s.length()) {
            return 0;
        }
        if (!Character.isDigit(s.charAt(i))) {
            if (s.charAt(i) == '-') {
                flag = true;
                i++;
            } else if (s.charAt(i) == '+') {
                i++;
            } else {
                return 0;
            }
        }
        int temp;
        for (int j = i; j < s.length(); j++) {
            if (!Character.isDigit(s.charAt(j))) {
                break;
            }
            temp = result;
            result = result * 10 + (s.charAt(j) - '0');
            //判断是否超过int类型的最大值
            if (result / 10 != temp) {
                if (flag) {
                    return Integer.MIN_VALUE;
                } else {
                    return Integer.MAX_VALUE;
                }
            }
        }
        //判断正负号
        if (flag) {
            result = -result;
        }
        return result;
    }

    /**
     * 实现 strStr()
     *
     * @param haystack 汉译：草垛
     * @param needle   汉译：针
     * @return 返回needle在haystack中第一次出现时的下标，如果没有返回-1
     */
    public static int strStr(String haystack, String needle) {
        //记录字符串的长度
        int len2 = needle.length();
        int len1 = haystack.length();
        //首先排除特殊的情况
        if (len2 == 0 || len1 == 0) {
            return -1;
        }
        //这题有点像kmp算法
        int i = 0;
        int j = 0;
        int[] next = getNext(needle);
        //双指针匹配字符
        while (i < haystack.length() && j < len2) {
            if (j == -1 || haystack.charAt(i) == needle.charAt(j)) {
                if (j == len2 - 1) {
                    //如果匹配成功，返回下标
                    return i - len2 + 1;
                }
                j++;
                i++;
            } else {
                j = next[j];
            }
        }
        return -1;
    }

    /**
     * kmp算法
     *
     * @param str 字符串
     * @return 数组
     */
    private static int[] getNext(String str) {
        int k = -1;
        int i = 0;
        int length = str.length();
        int[] next = new int[length];
        next[0] = -1;
        while (i < length - 1) {
            if (k == -1 || str.charAt(i) == str.charAt(k)) {
                k++;
                i++;
                next[i] = k;
            } else {
                k = next[k];
            }
        }
        return next;
    }

    /**
     * 外观数列(递归)
     *
     * @param n 第几层
     * @return 描述的字符串
     */
    public static String countAndSay(int n) {
        //第一层 "1"
        if (n == 1) {
            return "1";
        }
        //开始递归
        String str = countAndSay(n - 1);
        //拆分字符串
        int length = str.length();
        //记录字符串中相同元素的个数,默认是一
        int count = 1;
        //结果
        StringBuilder result = new StringBuilder();
        //只要判断到倒数第二个字符就可以了(如果str足够长的话)
        for (int i = 0; i < length - 1; i++) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                //当前字符和后一个字符相同count++;
                count++;
            } else {
                result.append(count);
                result.append(str.charAt(i));
                //重置count
                count = 1;
            }
        }
        ///判断最后一个字符是否和前一个字符相同
        if (count == 1) {
            ///如果count==1,就说明str.charAt(length-1)!=str.charAt(length-2);
            //还有就是str.length==1
            result.append(1);
        } else {
            result.append(count);
        }
        result.append(str.charAt(length - 1));
        return result.toString();
    }

    /**
     * 最长公共前缀
     *
     * @param strs 字符串数组
     * @return 返回最长的公共前缀
     */
    public static String longestCommonPrefix(String[] strs) {
//        //解法一
//        int length = strs.length;
//        StringBuilder result = new StringBuilder();
//        char temp;
//        //以第一个字符串为基准判断
//        for (int i = 0; i < strs[0].length(); i++) {
//            //获得第一个字符串第i位上的字符
//            temp=strs[0].charAt(i);
//            //与剩余的字符串进行判断
//            for (int j = 1; j < length; j++) {
//                if (i>=strs[j].length()||strs[j].charAt(i)!=temp){
//                    return result.toString();
//                }
//            }
//            result.append(temp);
//        }
//        return strs[0];
        //解法二：

        //以最小的字符串为基准判断
        //获取最小字符串的长度
        int min = Integer.MAX_VALUE;
        String minString = "";
        for (String item : strs) {
            if (item.length() < min) {
                min = item.length();
                minString = item;
            }
        }
        for (String item : strs) {
            boolean flag = false;
            while (min > 0) {
                flag = item.startsWith(minString.substring(0, min));
                if (flag) {
                    //如果匹配上了，就直接跳出while循环，匹配下一个字符串
                    break;
                } else {
                    min--;
                }
            }
        }
        return minString.substring(0, min);
    }
}
