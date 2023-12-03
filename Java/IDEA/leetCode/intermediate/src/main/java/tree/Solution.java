package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author 饮木
 * @Date 2022/7/12
 * @Description 树和图
 */
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        //中序遍历
        List<Integer> list = new ArrayList<>();
        infix(root, list);
        return list;
    }

    public void infix(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            infix(root.left, list);
        }
        list.add(root.val);
        if (root.right != null) {
            infix(root.right, list);
        }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        //标记奇偶层不同方向的遍历顺序
        //flag==false:从左到右
        //flag==true:从右到左
        boolean flag = false;
        //记录每层节点的数量
        int count;
        TreeNode temp;
        queue.add(root);
        while (!queue.isEmpty()) {
            count = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < count; i++) {
                //从队列中取出顶部元素
                temp = queue.poll();
                //判断此层的遍历方向
                if (flag) {
                    //从右到左，每次把元素放在集合的首部
                    list.add(0, temp.val);
                } else {
                    //从左到右
                    list.add(temp.val);
                }
                //添加下一层的元素
                if (temp.left != null) {
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }
            }
            //改变下一层的遍历方向
            flag = !flag;
            result.add(list);
        }
        return result;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildHelper(0, 0, inorder.length - 1, preorder, inorder);
    }

    /**
     * @param preIndex 前序遍历中根节点的位置
     * @param inStart  中序遍历中节点开始位置
     * @param inEnd    中序遍历中节点结束位置
     * @param preorder 前序遍历数组
     * @param inorder  中序遍历数组
     * @return 根节点
     */
    private TreeNode buildHelper(int preIndex, int inStart, int inEnd, int[] preorder, int[] inorder) {
        if (preIndex > preorder.length - 1 || inStart > inEnd) {
            return null;
        }
        //创建根节点
        TreeNode root = new TreeNode(preorder[preIndex]);
        //记录改根节点在中序遍历中的位置
        int index = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == root.val) {
                index = i;
                break;
            }
        }
        //递归根节点的左右子树
        root.left = buildHelper(preIndex + 1, inStart, index - 1, preorder, inorder);
        //preIndex + index - inStart + 1:根节点的下标-起始点的下标+1==所有左子树的长度
        //再加上原先根节点在前序遍历中的位置就得到改根节点右子树节点的下标
        root.right = buildHelper(preIndex + index - inStart + 1, index + 1, inEnd, preorder, inorder);
        return root;
    }

    public int numIslands(char[][] grid) {
        /*
        遍历二维数组中的每一个数，如果该数为1岛屿数量就加一。
        在遍历到值为1的时候，dfs把它相连的1都变为0，这样把一个比较大的岛屿，
        缩小。
         */
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(i,j,grid);
                }
            }
        }
        return count;
    }

    private void dfs(int i, int j, char[][] grid) {
        //退出条件
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0') {
            return;
        }
        //置为0
        grid[i][j] = '0';
        //上
        dfs(i - 1, j, grid);
        //下
        dfs(i + 1, j, grid);
        //左
        dfs(i, j - 1, grid);
        //右
        dfs(i, j + 1, grid);
    }
}
