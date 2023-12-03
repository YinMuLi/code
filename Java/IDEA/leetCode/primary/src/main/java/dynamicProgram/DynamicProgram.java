package dynamicProgram;


/**
 * @author 饮木
 * @Date 2022/7/4
 * @Description 动态规划
 */
public class DynamicProgram {
    /**
     * 爬楼梯
     *
     * @param n 楼梯的阶数
     * @return 返回爬楼梯的方法个数
     */
    public int climbStairs(int n) {
//        //C++课上，老师讲过，使用递归的方法
//        if (n == 1) {
//            //1
//            return 1;
//        }
//        if (n == 2) {
//            //1-1
//            //2
//            return 2;
//        }
//        //有两种爬楼的方法，一次爬一层和一次爬两层。
//        //最后一步可以为一步或者两步，所以递归开始了。
//        return climbStairs(n - 1) + climbStairs(n - 2);
        //非递归,这种方法就是把递归写成循环了
        if (n == 1) {
            return 1;
        }
        //楼梯的层数没有第零层
        int[] counts = new int[n + 1];
        counts[1] = 1;
        counts[2] = 2;
        //从三开始循环
        for (int i = 3; i < n + 1; i++) {
            counts[i] = counts[i - 1] + counts[i - 2];
        }
        return counts[n];
    }

    /**
     * 买卖股票的最佳时机
     *
     * @param prices 股票的数组
     * @return 最大利润
     */
    public int maxProfit(int[] prices) {
        //双指针
        int maxProfit = 0;
        int i = 0;
        int j = 1;
        while (j < prices.length) {
            if (prices[i] < prices[j]) {
                //如果后面的数字大于前面的数字，就表示有利润。
                //根最大利润比较
                if (prices[j] - prices[i] > maxProfit) {
                    maxProfit = prices[j] - prices[i];
                }
            } else {
                i = j;
            }
            j++;
        }
        return maxProfit;
    }

    /**
     * 最大子序和
     *
     * @param nums 题目数组
     * @return 最大子序和
     */
    public int maxSubArray(int[] nums) {
//        /*利用动态规划解决*/
//        //存储动态规划结果的数组
//        //program[i]：表示nums[i]为右端点的连续子数组的最大和
//        int[] program = new int[nums.length];
//        //nums[0]为右端点的连续子数组的最大和，只有它自己。
//        program[0] = nums[0];
//        int max = program[0];
//        for (int i = 1; i < nums.length; i++) {
//            //动态规划，转换公式。
//            program[i] = nums[i] + Math.max(program[i-1], 0);
//            //记录最大值
//            max = Math.max(max, program[i]);
//        }
//        return max;
        ///优化代码
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i] = Math.max(nums[i - 1], 0) + nums[i];
            max = Math.max(max, nums[i]);
        }
        return max;
    }

    /**
     * 打家劫舍
     *
     * @param nums 原数组
     * @return 打劫的最大金额
     */
    public int rob(int[] nums) {
        /*不能打劫相连的两家*/
        int length = nums.length;
        //rob[i][0]:表示第i+1家(数组中的下标是从零开始的)没偷时最大的金额
        //rob[i][1]:表示第i+1家被偷的时，最大的金额
        int[][] rob = new int[length][2];
        //第一家没偷时
        rob[0][0] = 0;
        //第一家被偷时
        rob[0][1] = nums[0];
        for (int i = 1; i < length; i++) {
            /*两种情况：
            1.第i+1被偷
            2.第i+1没被偷
             */
            //第i+1家被偷时，那么第i家一定没被偷
            rob[i][1] = rob[i - 1][0] + nums[i];
            //第i+1家没被偷时，那么第i家被不被偷都无所谓
            //那么比较第i家被偷时和没被偷时的金额，取最大值
            rob[i][0] = Math.max(rob[i - 1][0], rob[i - 1][1]);
        }
        return Math.max(rob[length - 1][0], rob[length - 1][1]);
    }

    /**
     * 打家劫舍(优化版本)
     *
     * @param nums 原数组
     * @return 打劫的最大金额
     */
    public int robOptimization(int[] nums) {
        //第一家没偷
        int notSteal = 0;
        //第一家被偷了
        int steal = nums[0];
        //临时变量
        int temp;
        for (int i = 1; i < nums.length; i++) {
            //没偷
            temp = notSteal;
            notSteal = Math.max(notSteal, steal);
            //偷
            steal = temp + nums[i];
        }
        return Math.max(notSteal, steal);
    }
}
