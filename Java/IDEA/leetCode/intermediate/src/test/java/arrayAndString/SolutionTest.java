package arrayAndString;

import junit.framework.TestCase;

import java.util.Arrays;

/**
 * @author 饮木
 * @Date 2022/7/7
 * @Description description
 */
public class SolutionTest extends TestCase {

    public void testThreeSum() {
        int[] test = {1, 2, 3, -1, 0};
        Solution solution = new Solution();
        System.out.println(solution.threeSum(test));
    }

    public void testLongestPalindrome() {
        Solution solution = new Solution();
        System.out.println(solution.longestPalindrome("cbbd"));
    }

    public void testIncreasingTriplet() {
        Solution solution = new Solution();
        int[] test = {0, 4, 2, 1, 0, -1, -3};
        System.out.println(solution.increasingTriplet(test));
    }
}