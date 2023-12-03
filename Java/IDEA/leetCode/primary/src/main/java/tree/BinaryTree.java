package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author 饮木
 * @Date 2022/7/3
 * @Description 二叉树
 */
public class BinaryTree {
    private BinaryTree() {
    }

    /**
     * 二叉树的最大深度
     *
     * @param root 根节点
     * @return 二叉树最大高度
     */
    public int maxDepth(TreeNode root) {
        //递归的方法寻找二叉树最大的深度
        if (root == null) {
            return 0;
        }
        int rightHeight = maxDepth(root.right);
        int leftHeight = maxDepth(root.left);
        return Math.max(rightHeight, leftHeight) + 1;
    }

    TreeNode previous;

    /**
     * 验证二叉搜索树
     *
     * @param root 根节点
     * @return true：是搜索二叉树；false：不是搜索二叉树
     */
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        //中序递归
        if (!isValidBST(root.left)) {
            return false;
        }
        //previous记录的是前一个节点
        if (previous != null && previous.val >= root.val) {
            return false;
        }
        previous = root;
        if (!isValidBST(root.right)) {
            return false;
        }
        return true;
    }

    /**
     * 对称二叉树
     *
     * @param root 根节点
     * @return true：是对称二叉树；false；不是对称二叉树
     */
    public boolean isSymmetric(TreeNode root) {
        return isEqual(root.right, root.left);
    }

    /**
     * 判断对称的两点是否相等
     *
     * @param node1 节点一
     * @param node2 节点二
     * @return true：节点一等于节点二；false；不相等
     */
    private boolean isEqual(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 != null && node2 != null && node1.val == node2.val) {
            //开始递归
            return isEqual(node1.right, node2.left) && isEqual(node1.left, node2.right);
        }
        return false;
    }

    /**
     * 二叉树的层序遍历
     *
     * @param root 根节点
     * @return 最层遍历结果的结合
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        //BFS宽度优先遍历
        //存放结果
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        //每层节点的数量
        int count;
        TreeNode temp;
        queue.add(root);
        //只要队列不为空就一直遍历下去
        while (!queue.isEmpty()) {
            //每遍历一层。添加一个集合
            List<Integer> list = new ArrayList<>();
            //上一层节点的个数
            count = queue.size();
            for (int i = 0; i < count; i++) {
                temp = queue.remove();
                //添加到结果集中
                list.add(temp.val);
                //先左后右
                if (temp.left != null) {
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }
            }
            //把这一层的结果存放到结果集中
            result.add(list);
        }
        return result;
    }

    /**
     * 将有序数组转换为二叉搜索树
     *
     * @param nums 转换为二叉树的升序数组
     * @return 二叉树的根节点
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    /**
     * 递归的方法将数组转换为二叉搜索树
     *
     * @param nums  原数组
     * @param start 数组开始索引
     * @param end   数组结束索引
     * @return 根节点
     */
    private TreeNode sortedArrayToBST(int[] nums, int start, int end) {
        if (start > end) {
            //跳出递归的条件
            return null;
        }
        //每次取数组的中点作为根节点
        int middleIndex = (start + end) / 2;
        //创建根节点
        TreeNode root = new TreeNode(nums[middleIndex]);
        //开始递归
        root.left = sortedArrayToBST(nums, start, middleIndex - 1);
        root.right = sortedArrayToBST(nums, middleIndex + 1, end);
        return root;
    }
}
