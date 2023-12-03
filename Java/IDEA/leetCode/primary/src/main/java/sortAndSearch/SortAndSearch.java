package sortAndSearch;

import org.hamcrest.core.StringStartsWith;

/**
 * @author 饮木
 * @Date 2022/7/4
 * @Description description
 */
public class SortAndSearch {
    /**
     * 合并两个有序数组，把数组二合并到数组一中
     *
     * @param nums1 数组一
     * @param m     数组一的长度
     * @param nums2 数组二
     * @param n     数组二的长度
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //nums1的尾索引
        int length = m + n - 1;
        //i数组一的指针
        int i = m - 1;
        //j数组二的指针
        int j = n - 1;
        //从后往前排序
        while (j >= 0) {
            //当数组一全部排序完的时候，就直接排序数组二
            if (i < 0 || nums2[j] > nums1[i]) {
                nums1[length--] = nums2[j--];
            } else {
                nums1[length--] = nums1[i--];
            }
        }
    }

    /**
     * 第一个错误的版本.
     * The isBadVersion API is defined in the parent class VersionControl.
     * boolean isBadVersion(int version);
     *
     * @param n 总共的版本号
     * @return 出错的版本号
     */
    public int firstBadVersion(int n) {
        //二分法查找错误的版本
        int start = 1;
        int end = n;
        //中间版本号
        int middle = 1;
        while (start < end) {
            //如果这样写(end+start)/2；会有种情况end+start的值大于int的最大值，然后导致while死循环
            middle = (end - start) / 2 + start;
            if (isBadVersion(middle)) {
                //如果当前的版本号是错误的版本号，就去前面的区域寻找是否也存在错误的版本
                end = middle;
            } else {
                //如果当前的版本号不是错误的版本号的话，那么错误的版本号肯定在后面。
                start = middle + 1;
            }
        }
        return start;
    }

    private boolean isBadVersion(int version) {
        return false;
    }
}
