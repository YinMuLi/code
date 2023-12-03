package design;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @Author 饮木
 * @Date 2022/8/1 15:41
 * @Description TODO
 */
public class RandomizedSetTest extends TestCase {

    public void testGetRandom() {
        RandomizedSet randomizedSet=new RandomizedSet();
        randomizedSet.insert(1);
        System.out.println(randomizedSet.remove(2));
        randomizedSet.insert(2);
        System.out.println(randomizedSet.getRandom());
        randomizedSet.remove(1);
        System.out.println(randomizedSet.insert(2));
        System.out.println(randomizedSet.getRandom());
    }
}