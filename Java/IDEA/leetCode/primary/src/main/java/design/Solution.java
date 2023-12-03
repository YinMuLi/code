package design;

import java.util.Random;

/**
 * @author 饮木
 * @Date 2022/7/6
 * @Description 打乱数组
 */
public class Solution {
    int[] nums;
    Random random;

    /**
     * 构造函数
     *
     * @param nums 数组
     */
    public Solution(int[] nums) {
        this.nums = nums;
        random = new Random();
    }

    /**
     * 重置数组
     *
     * @return 重置后的数组
     */
    public int[] reset() {
        return nums;
    }

    /**
     * 打乱数组，采用洗牌算法。
     *
     * @return 打乱后的数组
     */
    public int[] shuffle() {
        //克隆原数组
        int[] misc = nums.clone();
        /*
        洗牌算法：
        从数组中随机抽出一个数字和数组中的第一个元素或者最后一个元素交换，然后抽取随机数的范围缩小一位。
        循环上一步骤。
         */
        int index;
        int temp;
        //for:控制循环的次数
        for (int i = 0; i < misc.length; i++) {
            //random.nextInt(origin,bound):产生的随机数范围[origin,bound)
            index = random.nextInt(i, misc.length);
            //交换数组中的元素
            temp = misc[index];
            misc[index] = misc[i];
            misc[i] = temp;
        }
        return misc;
    }
}
