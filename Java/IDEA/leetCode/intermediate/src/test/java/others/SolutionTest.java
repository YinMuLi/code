package others;

import junit.framework.TestCase;

/**
 * @Author 饮木
 * @Date 2022/8/6 9:38
 * @Description TODO
 */
public class SolutionTest extends TestCase {
    Solution solution = new Solution();

    public void testEvalRPN() {
        String[] a = {"2", "1", "+", "3", "*"};
        System.out.println(solution.evalRPN(a));
        String[] b={"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println(solution.evalRPN(b));
        String[] c={"4","13","5","/","+"};
        System.out.println(solution.evalRPN(c));
    }
}