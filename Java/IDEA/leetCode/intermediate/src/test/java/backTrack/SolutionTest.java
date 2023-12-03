package backTrack;

import junit.framework.TestCase;

/**
 * @Author 饮木
 * @Date 2022/7/16 18:40
 * @Description TODO
 */
public class SolutionTest extends TestCase {

    public void testLetterCombinations() {
        Solution solution=new Solution();
        System.out.println(solution.letterCombinations("234"));
    }

    public void testPermute() {
        Solution solution=new Solution();
        int[] test={1,2,3};
        System.out.println(solution.permute(test));
    }

    public void testSubsets() {
        Solution solution=new Solution();
        int[] test={1,2,3};
        System.out.println(solution.subsets(test));
    }
}