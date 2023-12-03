package math;

import junit.framework.TestCase;

import java.util.Arrays;

/**
 * @author 饮木
 * @Date 2022/7/6
 * @Description description
 */
public class SolutionTest extends TestCase {

    public void testShuffle() {
        int[] test = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        Solution.shuffle(test);
        System.out.println(Arrays.toString(test));
        Solution.shuffle(test);
        System.out.println(Arrays.toString(test));
    }

    public void testFindPrime() {
        Solution.findPrime(12);
    }

    public void testRomanToInt() {
        Solution solution = new Solution();
        System.out.println(solution.romanToInt("MCMXCIV"));
    }
}