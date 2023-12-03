package design;

import junit.framework.TestCase;

import java.util.Random;

/**
 * @author 饮木
 * @Date 2022/7/6
 * @Description description
 */
public class SolutionTest extends TestCase {

    public void testShuffle() {
        Random random = new Random();
        System.out.println(random.nextInt(0, 2));
    }
}