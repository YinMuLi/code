package SortAndSearch;


import java.util.*;

/**
 * @Author 饮木
 * @Date 2022/7/19 19:11
 * @Description 排序和搜索
 */
public class Solution {
    public void sortColors(int[] nums) {
        //指向0结束的后一位
        int left = 0;
        //2开始的前一位
        int right = nums.length - 1;
        int index = 0;
        while (index <= right) {
            if (nums[index] < 1) {
                //0:往前移动
                swap(index++, left++, nums);
            } else if (nums[index] > 1) {
                //2:往后移动
                swap(index, right--, nums);
            } else {
                //1:index往后移动
                index++;
            }
        }
    }

    private void swap(int i, int j, int[] nums) {
        if (i != j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        //统计每个字符出现的次数
        for (int value : nums) {
            //map.getOrDefault(value,0):如果map集合中没有这个key就自动创建一个key个value，value默认值为0
            map.put(value, map.getOrDefault(value, 0) + 1);
        }
        //最大堆
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (int key : map.keySet()) {
            priorityQueue.add(new int[]{key, map.get(key)});
        }
        //取出堆中前k个元素
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = priorityQueue.remove()[0];
        }
        return result;
    }

    /**
     * 快速排序是先选择一个中枢（一般我们选第一个），然后遍历后面的元素，最终会把数组分为两部分，前面部分比中枢值小，后面部分大于或等于中枢值。
     * 分开之后中枢值所在的位置如果从后面数是第k个，我们直接返回中枢值即可。
     * 如果从后面数大于k，说明要找的值还在后面这部分，我们只需按照同样的方式从后面部分开始找即可。
     * 如果从后面数小于k，说明要找的值在前面部分，我们同样从前面部分开始查找。
     */
    public int findKthLargest(int[] nums, int k) {
        k = nums.length - k;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int i = left;
            for (int j = left + 1; j <= right; j++) {
                //把小于基准的数放到中心位置的左边
                if (nums[j] < nums[left]) {
                    swap(j, ++i, nums);
                }
            }
            swap(i, left, nums);
            if (i == k) {
                return nums[i];
            } else if (i < k) {
                left = i + 1;
            } else {
                right = i - 1;
            }
        }
        return -1;
    }

    public int findPeakElement(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            int right = i + 1;
            int left = i - 1;
            //只要大于左右两边就行了,如果遇到了边界就默认大于
            boolean flag = (left == -1 || nums[i] > nums[left]) && (right == nums.length || nums[i] > nums[right]);
            if (flag) {
                return i;
            }
        }
        return -1;
    }

    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        int left = 0;
        int right = nums.length - 1;
        int first = 0;
        //寻找出现target的下标
        while (left < right) {
            first = (right + left) / 2;
            if (nums[first] < target) {
                left = first + 1;
            } else if (nums[first] > target) {
                right = first - 1;
            } else {
                break;
            }
        }
        //从这个位置向左开始寻找是否还有值==target的元素
        while (first >= 1) {
            if (nums[first - 1] == target) {
                first -= 1;
            } else {
                break;
            }
        }
        for (int i = first; i < nums.length; i++) {
            if (nums[i] == target) {
                if (result[0] == -1) {
                    result[0] = i;
                }
                result[1] = i;
            }
        }
        return result;
    }

    public int[][] merge(int[][] intervals) {
        //以左端点进行排序
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> result = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            //只要该区间的右端点，比后一个区间的左端点大或者等于，就表示这两个区间可以合并在一起
            if (i + 1 < intervals.length && intervals[i][1] >= intervals[i + 1][0]) {
                //分情况讨论，怎么合并区间
                if (intervals[i][1] <= intervals[i + 1][1]) {
                    intervals[i + 1][0] = intervals[i][0];
                } else {
                    intervals[i + 1] = intervals[i];
                }
                continue;
            }
            //如果区间没有交集，就放入集合中
            result.add(new int[]{intervals[i][0], intervals[i][1]});
        }
        return result.toArray(new int[result.size()][2]);
    }

    public int search(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] <= target && matrix[i][matrix[0].length - 1] >= target) {
                int left = 0;
                int right = matrix[0].length - 1;
                while (left <= right) {
                    int middle = (left + right) / 2;
                    if (matrix[i][middle] == target) {
                        return true;
                    } else if (matrix[i][middle] < target) {
                        left = middle + 1;
                    } else {
                        right = middle - 1;
                    }
                }
            }
        }
        return false;
    }

    public boolean canJump(int[] nums) {
        /*
        1、dp[i] ：从i开始最多可以往后跳几步
        2、dp[i]=max(dp[i-1] - 1, nums[i])
        3、结束条件： dp[i] + i + 1 >= nums.len (返回true) 或者 dp[i]==0 (返回false)
         */
        if (nums.length == 1) {
            return true;
        }
        if (nums[0] == 0) {
            return false;
        }
        for (int i = 1; i < nums.length; i++) {
            nums[i] = Math.max(nums[i - 1] - 1, nums[i]);
            if (nums[i] >= nums.length - i - 1) {
                return true;
            } else if (nums[i] == 0) {
                return false;
            }
        }
        return false;
    }

    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] += dp[j - 1];
            }
        }
        return dp[n - 1];
    }

    public int coinChange(int[] coins, int amount) {
 /*
        完全背包之求凑满背包的最少物品数:
        容量->amount; 物品重量->coins[i]; 价值->1; 优化目标->求恰好凑满背包的物品最小价值
        1.状态定义:dp[j]为凑满容量为j的背包所需最少物品数
        2.状态转移:考虑coins[i]
            2.1 当j<coins[i]时:装不下,继承上一个dp[j]的值
            2.2 当j>=coins[i]时:可以装得下,可以选择装或者不装中价值小的(物品数小的)进行转移
                即:dp[j]=min(dp[j],dp[j-coins[i]+1])
        3.初始化:容量为0,最少要装0个就可以装满->dp[0]=0,看转移方程,其他的要初始化为Integer.MAX_VALUE
        4.遍历顺序:这里求最少的物品数,因此排列与组合均可,这里先物品后容量,物品顺序无所谓,容量必须正序(完全背包)
        5.返回形式:返回如果dp[amount]有转移直接返回,如果没有转移返回-1
         */
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int coin : coins) {
            // 正序,j从coin开始即可
            for (int j = coin; j <= amount; j++) {
                // 前面dp值在有计算过的基础上才能转移
                if (dp[j - coin] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j - coin] + 1);
                }
            }
        }
        // 有转移直接返回,没有转移说明凑不成返回-1
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

    public int lengthOfLIS(int[] nums) {
        //dp[i]:以nums[i]结束最长的子字符串
        int[] dp = new int[nums.length];
        int result=0;
        Arrays.fill(dp,1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j <=i; j++) {
                if (nums[i]>nums[j]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
            result=Math.max(result,dp[i]);
        }
        return result;
    }
}
