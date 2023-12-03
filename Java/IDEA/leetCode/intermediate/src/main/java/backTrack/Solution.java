package backTrack;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @Author 饮木
 * @Date 2022/7/16 18:05
 * @Description 回溯
 */
public class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return new ArrayList<>();
        }
        Map<Character, String> map = new HashMap<>(8);
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "qprs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        List<String> result = new ArrayList<>();
        letter(map, digits, result, "");
        return result;
    }

    private void letter(Map<Character, String> map, String digits, List<String> result, String temp) {
        //推出回溯的条件
        if (temp.length() == digits.length()) {
            //结束，把结果添加到结果集中
            result.add(temp);
            return;
        }
        //查看上一次遍历的长度
        int length = temp.length();
        String str = map.get(digits.charAt(length));
        for (int i = 0; i < str.length(); i++) {
            //temp+str.charAt(i)是创建新的对象
            letter(map, digits, result, temp + str.charAt(i));
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        dfs(n, n, result, "");
        return result;
    }

    /**
     * @param left   左边括号剩余的数量
     * @param right  右边括号剩余的数量
     * @param result 存放的结果集
     * @param temp   拼接的字符串
     */
    private void dfs(int left, int right, List<String> result, String temp) {
        if (left == 0 && right == 0) {
            result.add(temp);
            return;
        }
        if (left < 0 || right < left) {
            //左边的括号一定大于等于右边的括号
            return;
        }
        //左括号
        dfs(left - 1, right, result, temp + '(');
        //右括号
        dfs(left, right - 1, result, temp + ')');
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        permute(nums, result, new ArrayList<>());
        return result;
    }

    private void permute(int[] nums, List<List<Integer>> result, List<Integer> temp) {
        if (temp.size() == nums.length) {
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int num : nums) {
            if (temp.contains(num)) {
                //排除重复的值
                continue;
            }
            temp.add(num);
            //开始递归
            permute(nums, result, temp);
            //取消递归的影响
            temp.remove(temp.size() - 1);
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        //添加空集,任何集合都有空集
        result.add(new ArrayList<>());
        subsets(0, result, nums, new ArrayList<>());
        return result;
    }

    private void subsets(int startIndex, List<List<Integer>> result, int[] nums, List<Integer> temp) {
        if (temp.size() == nums.length) {
            return;
        }
        for (int i = startIndex; i < nums.length; i++) {
            temp.add(nums[i]);
            result.add(new ArrayList<>(temp));
            //递归
            subsets(i + 1, result, nums, temp);
            temp.remove(temp.size() - 1);
        }
    }

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (exist(i, j, board, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean exist(int i, int j, char[][] board, String word, int index) {
        //推出递归的条件
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(index)) {
            return false;
        }
        if (index == word.length() - 1) {
            return true;
        }
        //记录改变的数字
        char temp = board[i][j];
        board[i][j] = '.';
        boolean flag = exist(i + 1, j, board, word, index + 1) ||
                exist(i - 1, j, board, word, index + 1) ||
                exist(i, j + 1, board, word, index + 1) ||
                exist(i, j - 1, board, word, index + 1);
        //还原成原先的值
        board[i][j] = temp;
        return flag;
    }

}
