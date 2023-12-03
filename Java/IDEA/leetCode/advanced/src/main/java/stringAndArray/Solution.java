package stringAndArray;

import java.util.*;

/**
 * @Author 饮木
 * @Date 2022/8/8 10:32
 * @Description TODO
 */
public class Solution {
    public int[] productExceptSelf(int[] nums) {
        /*
        不准使用除法
         */
        int[] answer = new int[nums.length];
        int length = nums.length;
        answer[0] = 1;
        //当前元素左边元素的乘积
        for (int i = 1; i < nums.length; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }
        int right = 1;
        //当前元素左边元素乘以右边的元素
        for (int i = length - 1; i >= 0; i--) {
            answer[i] *= right;
            right *= nums[i];
        }
        return answer;
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        //记录矩阵的行数
        int row = matrix.length;
        //记录矩阵的列数
        int column = matrix[0].length;
        int up = 0;
        int right = column - 1;
        int down = row - 1;
        int left = 0;
        while (up <= down && left <= right) {
            for (int i = left; i <= right; i++) {
                res.add(matrix[up][i]);
            }
            for (int i = up + 1; i <= down; i++) {
                res.add(matrix[i][right]);
            }
            if (left < right && down > up) {
                for (int i = right - 1; i > left; i--) {
                    res.add(matrix[down][i]);
                }
                for (int i = down; i > up; i--) {
                    res.add(matrix[i][left]);
                }
            }

            up++;
            down--;
            left++;
            right--;
        }
        return res;
    }

    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int count = 0;
        //map集合用来存储前两个数组相加排列的所有情况
        //key：值
        //value：这个值的出现的次数
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums1) {
            for (int j : nums2) {
                int value = j + i;
                map.put(value, map.getOrDefault(value, 0) + 1);
            }
        }

        for (int i : nums3) {
            for (int j : nums4) {
                int value = i + j;
                count += map.getOrDefault(-value, 0);
            }
        }
        return count;
    }

    public int maxArea(int[] height) {
        /*
        木桶效应：盛水的容量取决于最短板。
        木桶底部长度尽可能长的情况下，木桶的最小高度尽可能高。
         */
        int left = 0;
        int right = height.length - 1;
        int res = 0;
        while (left < right) {
            //木桶的短板
            int minHeight = Math.min(height[left], height[right]);
            res = Math.max(res, minHeight * (right - left));
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return res;
    }

    public void gameOfLife(int[][] board) {
        int row = board.length;
        int column = board[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                //统计该格子的八个方向活细胞个个数
                int live = 0;
                //上
                if (i - 1 >= 0 && board[i - 1][j] >= 1) {
                    live++;
                }
                //右上
                if (i - 1 >= 0 && j + 1 < column && board[i - 1][j + 1] >= 1) {
                    live++;
                }
                //右
                if (j + 1 < column && board[i][j + 1] >= 1) {
                    live++;
                }
                //右下
                if (i + 1 < row && j + 1 < column && board[i + 1][j + 1] >= 1) {
                    live++;
                }
                //下
                if (i + 1 < row && board[i + 1][j] >= 1) {
                    live++;
                }
                //左下
                if (i + 1 < row && j - 1 >= 0 && board[i + 1][j - 1] >= 1) {
                    live++;
                }
                //左
                if (j - 1 >= 0 && board[i][j - 1] >= 1) {
                    live++;
                }
                //左上
                if (j - 1 >= 0 && i - 1 >= 0 && board[i - 1][j - 1] >= 1) {
                    live++;
                }
                /*
                如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡；
                如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活；
                如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡；
                如果死细胞周围正好有三个活细胞，则该位置死细胞复活；
                 */
                if ((live < 2 || live > 3) && board[i][j] == 1) {
                    board[i][j] = 2;
                } else if (live == 3 && board[i][j] == 0) {
                    board[i][j] = -1;
                }
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (board[i][j] == 2) {
                    board[i][j] = 0;
                } else if (board[i][j] == -1) {
                    board[i][j] = 1;
                }
            }
        }
    }

    public int firstMissingPositive(int[] nums) {
        int length = nums.length;
        for (int i = 0; i < length; ) {
            if (nums[i] != i + 1 && nums[i] < length && nums[i] > 0 && nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
                continue;
            }
            i++;
        }
        for (int i = 0; i < length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return length + 1;
    }

    private void swap(int[] nums, int i, int j) {
        if (i != j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }

    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        int maxLength = 0;
        int temp = 1;
        for (int i = 0; i < nums.length; i++) {
            if (i + 1 < nums.length) {
                if (nums[i] == nums[i + 1] - 1) {
                    temp++;
                } else if (nums[i] != nums[i + 1]) {
                    temp = 1;
                }
            }
            maxLength = Math.max(maxLength, temp);
        }
        return maxLength;
    }

    public int findDuplicate(int[] nums) {
        int[] duplicate = new int[nums.length];
        //-1:这个数字只出现一次
        for (int num : nums) {
            if (duplicate[num - 1] != -1) {
                duplicate[num - 1] = -1;
                continue;
            }
            return num;
        }
        return -1;
    }

    public int calculate(String s) {
        int res = 0;
        Deque<Integer> deque = new LinkedList<>();
        //去除空格
        s = s.replace(" ", "");
        int length = s.length();
        int number = 0;
        char operator = '+';
        for (int i = 0; i < length; i++) {
            char temp = s.charAt(i);
            if (Character.isDigit(temp)) {
                number = number * 10 + temp - '0';
            }
            if (!Character.isDigit(temp) || i == length - 1) {
                if (operator == '+') {
                    deque.addLast(number);
                } else if (operator == '-') {
                    deque.addLast(-number);
                } else if (operator == '*') {
                    deque.add(deque.removeLast() * number);
                } else {
                    deque.add(deque.removeLast() / number);
                }
                operator = temp;
                number = 0;
            }
        }
        while (!deque.isEmpty()) {
            res += deque.remove();
        }
        return res;
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> queue = new LinkedList<>();
        //求出最大值
        for (int i = 0; i < k - 1; i++) {
            while (!queue.isEmpty() && queue.getLast() < nums[i]) {
                queue.pollLast();
            }
            queue.offerLast(nums[i]);
        }
        //定义存放结果的数组
        int[] res = new int[nums.length - k + 1];
        for (int i = k - 1; i < nums.length; i++) {
            while (!queue.isEmpty() && queue.getLast() < nums[i]) {
                queue.pollLast();
            }
            queue.offerLast(nums[i]);
            res[i - k + 1] = queue.getFirst();
            //排除超过窗口的情况
            if (queue.getFirst() == nums[i - k + 1]) {
                queue.pollFirst();
            }
        }
        return res;
    }

    public String minWindow(String s, String t) {
        //转换为字符数组
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        //'A'-65 'z'-122 所有字符的长度就是58
        //need:记录t中每个字符出现的个数
        int[] need = new int[58];
        //window:记录滑动窗口中每个字符出现的个数
        int[] window = new int[58];
        //统计t中每个字符出现的个数
        for (char c : tc) {
            need[c - 'A']++;
        }
        //记录t中一共有多少个字符
        int count = tc.length;
        //滑动窗口的起点
        int start = 0;
        //滑动窗口的最小长度
        int minLen = Integer.MAX_VALUE;
        //左右指针
        int right = 0;
        int left = 0;
        //当右指针到达最右点时结束循环
        while (right < sc.length) {
            int c = sc[right] - 'A';
            right++;

            if (need[c] > 0) {
                //如果t中含有相同的字符，滑动窗口对应的字符++
                window[c]++;
                if (need[c] >= window[c]) {
                    //如果滑动窗口对应的字符数量小于t中的表示有效匹配
                    count--;
                }
            }
            //count==0:表示一个有效的滑动窗口
            while (count == 0) {
                //停止调整右指针，开始缩小滑动窗口的范围
                if (right - left < minLen) {
                    //计算窗口的起始点和长度
                    start = left;
                    minLen = right - left;
                }
                int d = sc[left] - 'A';
                left++;
                if (need[d] > 0) {
                    if (need[d] >= window[d]) {
                        count++;
                    }
                    window[d]--;
                }
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}
