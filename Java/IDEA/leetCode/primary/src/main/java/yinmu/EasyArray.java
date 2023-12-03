package yinmu;

import java.util.*;

/**
 * @author 饮木
 * @Date 2022/6/22
 * @Description description
 */
public class EasyArray {
    private EasyArray() {
    }

    /**
     * 删除排序数组中的重复项
     *
     * @param nums 传入升序的数组
     * @return 修改后数组的长度
     */
    public static int removeDuplicates(int[] nums) {
        //记录重复的数字
        int count = 0;
        int length = nums.length;
        //双指针
        int i = 0;
        int j = 1;
        while (j < length) {
            if (nums[i] == nums[j]) {
                //数组中出现重复的数字
                count++;
            } else {
                i++;
                nums[i] = nums[j];
            }
            j++;
        }
        return length - count;
    }

    /**
     * 买卖股票的最佳时机 II
     *
     * @param prices prices[i] 表示某支股票第 i 天的价格。
     * @return 最大的利润
     */
    public static int maxProfit(int[] prices) {
        //profit利润
        int profit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i] < prices[i + 1]) {
                profit += prices[i + 1] - prices[i];
            }
        }
        return profit;
    }

    /**
     * 旋转数组
     *
     * @param nums 要旋转的数组
     * @param k    旋转的位数，不能为负数
     */
    public static void rotate(int[] nums, int k) {
        //数组反转，三次反转数组
        int length = nums.length;
        k %= length;
        //第一次，整个数组进行反转
        reverse(nums, 0, length - 1);
        //第二次，反转[0,k%length-1]
        reverse(nums, 0, k - 1);
        //第三次，反转[k%length,length-1]
        reverse(nums, k, length - 1);
    }

    /**
     * 反转数组
     *
     * @param nums  要反转的数组
     * @param start 起点下标
     * @param end   终点下标
     */
    public static void reverse(int[] nums, int start, int end) {
        int temp;
        while (start < end) {
            temp = nums[end];
            nums[end] = nums[start];
            nums[start] = temp;
            start++;
            end--;
        }
    }

    /**
     * 存在重复元素
     *
     * @param nums 数组
     * @return 数组中存在重复的数就返回true，否则是false
     */
    public static boolean containsDuplicate(int[] nums) {
        //利用set集合进行去重
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
        }
        return false;
    }

    /**
     * 只出现一次的数字
     *
     * @param nums 数组
     * @return 返回数组中只出现一次的元素
     */
    public static int singleNumber(int[] nums) {
//        a^a=0；自己和自己异或等于0
//        a^0=a；任何数字和0异或还等于他自己
//        a^b^c=a^c^b；异或运算具有交换律
        int reduce = 0;
        for (int num : nums) {
            reduce = reduce ^ num;
        }
        return reduce;
    }

    /**
     * 两个数组的交集 II <br/>
     * intersect：相交
     *
     * @param nums1 数组一
     * @param nums2 数组二
     * @return 返回相交数构成的数组
     */
    public static int[] intersect(int[] nums1, int[] nums2) {
        //先对两个数组进行升序排序
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        //构建存放结果的数组
        int length1 = nums1.length;
        int length2 = nums2.length;
        int[] result = new int[Math.min(length1, length2)];
        //利用双指针解决
        int i = 0;
        int j = 0;
        //记录存放的个数
        int count = 0;
        while (i < length1 && j < length2) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                result[count++] = nums1[i];
                i++;
                j++;
            }
        }
        return Arrays.copyOfRange(result, 0, count);
    }

    /**
     * 加一
     *
     * @param digits 原数组
     * @return 数组加一后的数组
     */
    public static int[] plusOne(int[] digits) {
        //如果数组是[9,9]，加一后就变成了100，就需要扩容
        //其它情况就正常加一就可以了
        int length = digits.length;
        //加一
        digits[length - 1] += 1;
        int i = length - 1;
        while (i >= 0) {
            if (i == 0 && digits[i] == 10) {
                //设置第一个元素为1，因为新创建的数组没有赋值的话，默认是0
                //比如[9,9]就变成了[1,0,0]
                digits = new int[length + 1];
                digits[0] = 1;
            } else {
                if (digits[i] == 10) {
                    //当前下标的元素设置为0
                    //前一个元素+1
                    digits[i] = 0;
                    digits[i - 1] += 1;
                    i--;
                } else {
                    break;
                }
            }
        }
        return digits;
    }

    /**
     * 移动零
     *
     * @param nums 原数组
     */
    public static void moveZeroes(int[] nums) {
        //双指针
        int j = 0;
        int temp;
        for (int i = 0; i < nums.length; i++) {
            //只要不是零就往前移动
            if (nums[i] != 0) {
                temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            }
        }
    }

    /**
     * 两数之和
     *
     * @param nums   原数组
     * @param target 目标值
     * @return 原数组中相加为target的下标
     */
    public static int[] twoSum(int[] nums, int target) {
        int length = nums.length;
        Map<Integer, Integer> map = new HashMap<>(length);
        for (int i = 0; i < length; i++) {
            if (map.containsKey(target - nums[i])) {
                //如果map集合中存在这两个数之和为target
                //返回其下标组成的数组
                return new int[]{i, map.get(target - nums[i])};
            }
            map.put(nums[i], i);
        }
        return new int[2];
    }

    /**
     * 有效数独
     *
     * @param board 组成数独的二维数组
     * @return true-有效数独；false-不是有效数独
     */
    public static boolean isValidSudoku(char[][] board) {
        //数独都是9*9的，这个获取长度可以不写
        int length = board.length;
        //利用三个二维数组来记录每行，每列，每个区域出现的数字
        //比如 row[0][3]==1，表示第一行存在3这个元素
        //1表示存在，0表示不存在
        int[][] row = new int[length][length];
        int[][] column = new int[length][length];
        int[][] cell = new int[length][length];
        //用来存放下标
        int index;
        //存放是第几个3*3的区域
        int cellIndex;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (board[i][j] == '.') {
                    //如果这个单元格没有数据，就进行下一轮
                    continue;
                }
                //利用ASCII码的运算，把字符转换为int类型的数据
                //比如board[i][j]的值为'9'
                //'9'-'0'=9
                //这里在减一是防止下标越界，超过数组的长度
                index = board[i][j] - '1';
                //计算是第几个3*3的区域
                //0-1-2
                //3-4-5
                //6-7-8
                cellIndex = (i / 3) * 3 + j / 3;
                if (row[i][index] != 0 || column[j][index] != 0 || cell[cellIndex][index] != 0) {
                    //出先了重复的数字，就说明不是有效的数独
                    return false;
                }
                //把出现过的数字添加到三个二维数组中
                row[i][index] = column[j][index] = cell[cellIndex][index] = 1;
            }
        }
        return true;
    }

    /**
     * 旋转图像
     *
     * @param matrix 正方形矩阵数组
     */
    public static void rotate(int[][] matrix) {
        int length = matrix.length;
        int temp;
        //先斜对角互换，然后再上下互换
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                //斜对角换值
                temp = matrix[i][j];
                matrix[i][j] = matrix[length - 1 - j][length - 1 - i];
                matrix[length - 1 - j][length - 1 - i] = temp;
            }
        }
        //上下互换
        //只要换半的行数就行了
        for (int i = 0; i < length / 2; i++) {
            for (int j = 0; j < length; j++) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[length - 1 - i][j];
                matrix[length - 1 - i][j] = temp;
            }
        }
    }
}
