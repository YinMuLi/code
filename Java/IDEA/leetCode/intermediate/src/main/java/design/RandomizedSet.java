package design;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @Author 饮木
 * @Date 2022/8/1 15:34
 * @Description TODO
 */
public class RandomizedSet {
    List<Integer> list;

    public RandomizedSet() {
        list = new ArrayList<>();
    }

    public boolean insert(int val) {
        if (list.contains(val)) {
            return false;
        }
        list.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (list.contains(val)) {
            //这里如果是remove(val)是根据集合中的下标删除的
            list.remove((Integer) val);
            return true;
        }
        return false;
    }

    public int getRandom() {
        int count = list.size();
        Random random = new Random();
        int index = random.nextInt(count);
        return list.get(index);
    }
}
