package other;

import junit.framework.TestCase;


/**
 * @author 饮木
 * @Date 2022/7/6
 * @Description description
 */
public class SolutionTest extends TestCase {

    public void testGenerate() {
        Solution solution = new Solution();
        System.out.println(solution.generate(5));
    }

    public void testIsValid() {
        int a = '(';
        int b = '{';
        int c = '}';
        int e = ')';
        int f = '[';
        int g = ']';
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(e);
        System.out.println(f);
        System.out.println(g);
    }
}