package math;

import junit.framework.TestCase;

import javax.xml.transform.Source;
import java.util.logging.Logger;

/**
 * @Author 饮木
 * @Date 2022/8/3 16:47
 * @Description TODO
 */
public class SolutionTest extends TestCase {

    Logger logger=Logger.getLogger("math.SolutionTest");
    Solution solution=new Solution();
    public void testTitleToNumber() {
        System.out.println(solution.titleToNumber("ZAB"));
    }

    public void testMyPow() {
        System.out.println(solution.myPow(5,2));
    }

    public void testMySqrt() {
        System.out.println(solution.mySqrt(2147395599));
        System.out.println(solution.mySqrt(8));
    }

    public void testFractionToDecimal() {
        System.out.println(solution.fractionToDecimal(10,-2));
        System.out.println(solution.fractionToDecimal(7,-12));
        System.out.println(solution.fractionToDecimal(0,-5));
        System.out.println(solution.fractionToDecimal(-50,8));
        System.out.println(solution.fractionToDecimal(-1,-2147483648));
        System.out.println(solution.fractionToDecimal(-2147483648,-1));
    }
}