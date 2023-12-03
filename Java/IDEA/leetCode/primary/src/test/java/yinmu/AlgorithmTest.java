package yinmu;

import junit.framework.TestCase;

import java.util.Arrays;

/**
 * @author 饮木
 * @Date 2022/6/22
 * @Description description
 */
public class AlgorithmTest extends TestCase {

    public void testRemoveDuplicates() {
        int[] test = {1, 1, 2};
        System.out.println(EasyArray.removeDuplicates(test));
    }

    public void testMaxProfit() {
        int[] test = {1, 2, 3, 4, 5};
        System.out.println(EasyArray.maxProfit(test));
    }

    public void testRotate() {
        int[] test = {-1, -100, 3, 99};
        EasyArray.rotate(test, 2);
    }

    public void testPlusOne() {
        int[] test = {9, 9, 9};
        EasyArray.plusOne(test);
    }

    public void testMoveZeroes() {
        int[] test = {1, 5, 6, 0, 3};
        EasyArray.moveZeroes(test);
    }

    public void testTwoSum() {
        int[] test = {1, 5, 3, 9};
        System.out.println(Arrays.toString(EasyArray.twoSum(test, 14)));
    }

    public void testIsValidSudoku() {
        System.out.println(6 << 1);//12
        System.out.println(6 << 2);//24
    }

    public void testTestRotate() {
        int[][] test = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        EasyArray.rotate(test);
    }
}