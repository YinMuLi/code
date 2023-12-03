package arrayAndString;


import java.util.*;

/**
 * @author 饮木
 * @Date 2022/7/7
 * @Description 数组和字符串
 */
public class Solution {
    /**
     * 三数之和。除了三层for循环之外(而且去重也不知道怎么去重)，
     * 我是真的想不到其它的方法。
     */
    public List<List<Integer>> threeSum(int[] nums) {
        //对数组进行排序
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        //length-2:题目要求是求三个数的和为0，所以只要遍历到数组下标为length-3的数就可以了
        for (int i = 0; i < nums.length - 2; i++) {
            //从第二个元素开始
            if (i > 0 && nums[i] == nums[i - 1]) {
                //如果当前的数字和前面的一位相同，就表示重复了，就进行下一轮
                continue;
            }
            //数组进过排序后，如果改值大于零，那么它后面的数字肯定也大于0，是不可能相加为0的.
            //这时直接跳出循环
            if (nums[i] > 0) {
                break;
            }
            //下面利用双指针寻找指定的值
            //左指针
            int left = i + 1;
            //右指针
            int right = nums.length - 1;
            //需要寻找的目标值
            int target = -nums[i];
            //头尾指针相加的和
            int sum;
            while (left < right) {
                sum = nums[left] + nums[right];
                if (sum == target) {
                    //如果左右指针指向的数字相加等于要寻找的值，就把结果加入集合
                    //Arrays.asList():该方法是将数组转化成List集合的方法。
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    //对左右指针去重
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    //如果没有重复的话，左右指针自然移动
                    left++;
                    right--;
                } else if (sum > target) {
                    //比目标值大，右指针左移
                    right--;
                } else {
                    //比目标值小，左指针右移
                    left++;
                }
            }
        }
        return result;
    }

    /**
     * 暴力解法
     */
    public void setZeroes(int[][] matrix) {
        boolean[] row = new boolean[matrix.length];
        boolean[] column = new boolean[matrix[0].length];
        //遍历矩阵，统计出哪些行和列需要归零
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    //找到矩阵中为0的数字，把它所在的行和列记录下来
                    row[i] = true;
                    column[j] = true;
                }
            }
        }
        //归零操作
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (row[i] || column[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        //排除极端情况
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }
        Map<String, List<String>> result = new HashMap<>();
        String temp;
        for (String str : strs) {
            temp = str;
            //转换为chars数组，然后进行排序
            char[] chars = temp.toCharArray();
            Arrays.sort(chars);
            //把排序后的chars数组，转换为String
            temp = String.valueOf(chars);
            if (!result.containsKey(temp)) {
                //如果map不包含此键值，创建该简直
                result.put(temp, new ArrayList<>());
            }
            result.get(temp).add(str);

        }
        return new ArrayList<>(result.values());
    }

    public int lengthOfLongestSubstring(String s) {
        Queue<Character> queue = new LinkedList<>();
        int maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            if (queue.contains(s.charAt(i))) {
                //如果包含该字符，就弹出队列顶部的元素，直到不在包含该字符
                while (queue.contains(s.charAt(i))) {
                    queue.remove();
                }
            }
            queue.add(s.charAt(i));
            //取最大值
            maxLen = Math.max(maxLen, queue.size());
        }
        return maxLen;
    }

    public String longestPalindrome(String s) {
        //匹配回文子字符串的最大长度
        int maxLen = 0;
        //记录回文子字符串的开始位置
        int start = 0;
        int length = s.length();
        for (int i = 0; i < length; ) {
            //如果剩余的长度小于最大长度，可以直接退出
            if (length - i < maxLen / 2) {
                break;
            }
            int left = i;
            int right = i;
            //如果当前字符和它右边的相等，就跳过
            while (right < length - 1 && s.charAt(right) == s.charAt(right + 1)) {
                right++;
            }
            //手动调整i的值,从重复的下一个字符开始判断
            i = right + 1;
            while (right < length - 1 && left > 0 && s.charAt(left - 1) == s.charAt(right + 1)) {
                right++;
                left--;
            }
            //更新最大的长度
            if (right - left + 1 > maxLen) {
                start = left;
                maxLen = right - left + 1;
            }
        }
        //s.substring的截取范围是[start,start+maxLen);
        return s.substring(start, start + maxLen);
    }

    public boolean increasingTriplet(int[] nums) {
        //记录三个数字中最小的值
        int min = Integer.MAX_VALUE;
        //记录三个数字中第二小的值
        int middle = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num <= min) {
                //小于最小值更新最小值
                min = num;
            } else if (num <= middle) {
                //小于中间值更新中间值
                middle = num;
            } else {
                //大于第一小值和第二小值,存在题目中描述的下标组合
                return true;
            }
        }
        return false;
    }
}