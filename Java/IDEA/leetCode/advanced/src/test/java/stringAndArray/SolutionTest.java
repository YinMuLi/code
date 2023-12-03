package stringAndArray;

import junit.framework.TestCase;

import java.util.Arrays;

/**
 * @Author 饮木
 * @Date 2022/8/8 10:42
 * @Description TODO
 */
public class SolutionTest extends TestCase {
    Solution solution = new Solution();

    public void testProductExceptSelf() {
        int[] test = new int[]{1, 2, 3, 4};
        System.out.println(Arrays.toString(solution.productExceptSelf(test)));
    }

    public void testSpiralOrder() {
        int[][] a = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
//        System.out.println(solution.spiralOrder(a));
        int[][] b = {{7}, {9}, {6}};
//        System.out.println(solution.spiralOrder(b));
        int[][] c = {{2, 5}, {8, 4}, {0, -1}};
//        System.out.println(solution.spiralOrder(c));
        int[][] d = {{2, 5, 8}, {4, 0, -1}};
//        System.out.println(solution.spiralOrder(d));
        int[][] e = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(solution.spiralOrder(e));
//        [1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7]
//        [7, 9, 6]
//        [2, 5, 4, -1, 0, 8]
//        [2, 5, 8, -1, 0, 4]
    }

    public void testGameOfLife() {
        int[][] test = {{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}};
        solution.gameOfLife(test);
        System.out.println(Arrays.deepToString(test));
    }

    public void testFirstMissingPositive() {
        int[] a = {0, 1, 2};
        System.out.println(solution.firstMissingPositive(a));
        int[] b = {0, 2, 2, 1, 1};
        System.out.println(solution.firstMissingPositive(b));
        int[] c = {-1, 4, 2, 1, 9, 10};
        System.out.println(solution.firstMissingPositive(c));
    }

    public void testLongestConsecutive() {
        int[] a={100,4,200,1,3,2};
        System.out.println(solution.longestConsecutive(a));
        int[] b={1,2,0,1};
        System.out.println(solution.longestConsecutive(b));
    }

    public void testCalculate() {
        System.out.println(solution.calculate(" 3+5 / 2 "));
//        System.out.println(solution.calculate("3+2*2"));
    }

    public void testMaxSlidingWindow() {
        int[] a={1,3,-1,-3,5,3,6,7};
        System.out.println(Arrays.toString(solution.maxSlidingWindow(a, 3)));
        int[] b={1,-1};
        System.out.println(Arrays.toString(solution.maxSlidingWindow(b, 1)));
        int[] c={9,10,9,-7,-4,-8,2,-6};
        System.out.println(Arrays.toString(solution.maxSlidingWindow(c, 5)));
    }

    public void testMinWindow() {
        System.out.println((int) ('z'));
    }
}