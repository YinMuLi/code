package tree;

import junit.framework.TestCase;

/**
 * @author 饮木
 * @Date 2022/7/13
 * @Description description
 */
public class SolutionTest extends TestCase {

    public void testBuildTree() {
        Solution solution=new Solution();
        int[] A={3,9,20,15,7};
        int[] B={9,3,15,20,7};
        System.out.println(solution.buildTree(A,B));
    }
}