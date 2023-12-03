package SortAndSearch;

import junit.framework.TestCase;

import java.util.Arrays;

/**
 * @Author 饮木
 * @Date 2022/7/19 19:24
 * @Description TODO
 */
public class SolutionTest extends TestCase {

    public void testSortColors() {
        Solution solution=new Solution();
        int [] test={0,2,1,0,2,1};
        solution.sortColors(test);
        System.out.println(Arrays.toString(test));
    }

    public void testFindKthLargest() {
        Solution solution=new Solution();
        int[] test={3,2,1,4,5};
        System.out.println(solution.findKthLargest(test,2));
    }

    public void testFindPeakElement() {
        Solution solution=new Solution();
        int[] test={1,2,3,1};
        System.out.println(solution.findPeakElement(test));
    }

    public void testSearchRange() {
        Solution solution=new Solution();
        int[] test={5,7,7,8,8,10};
        System.out.println(Arrays.toString(solution.searchRange(test, 6)));
    }

    public void testMerge() {
        int[][] test={{1,4},{4,5}};
        Solution solution=new Solution();
        System.out.println(Arrays.deepToString(solution.merge(test)));
    }

    public void testUniquePaths() {
        Solution solution=new Solution();
        System.out.println(solution.uniquePaths(3,7));
    }

    public void testLengthOfLIS() {
        Solution solution=new Solution();
        int[] test={10,9,2,5,3,7,101,18};
        System.out.println(solution.lengthOfLIS(test));
    }
}