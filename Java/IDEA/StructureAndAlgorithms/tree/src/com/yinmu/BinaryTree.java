package com.yinmu;

/**
 * @author 饮木
 * @Date 2022年06月17日21时01分
 */
public class BinaryTree {
    /**
     * 根节点
     */
    private StudentNode root;

    public BinaryTree() {
    }

    public BinaryTree(StudentNode root) {
        this.root = root;
    }

    public StudentNode getRoot() {
        return root;
    }

    public void setRoot(StudentNode root) {
        this.root = root;
    }

    /**
     * 前序遍历,中序和后续差不多
     *
     * @param node 遍历节点
     */
    private void prefixErgodic(StudentNode node) {
        //先输出根节点
        System.out.println(node);
        //判断是否存在有左子树
        if (node.getLeft() != null) {
            //从左边开始递归
            prefixErgodic(node.getLeft());
        }
        //判断是否存在右子树
        if (node.getRight() != null) {
            //从右边开始递归
            prefixErgodic(node.getRight());
        }
    }

    /**
     * 分装前序遍历
     */
    public void prefixErgodic() {
        if (root == null) {
            //根节点为空就直接返回
            System.out.println("当前二叉树无法遍历！");
            return;
        }
        //从根节点开始遍历
        prefixErgodic(root);
    }

    /**
     * 利用前序遍历查找对应id的学生
     *
     * @param id   要查找的学生id
     * @param node 节点
     * @return 找到就返回学生对象，没有就返回null
     */
    private StudentNode find(StudentNode node, int id) {
        //临时存储找到的节点
        StudentNode temp = null;
        //先看当前节点是否为符合要求
        if (node.getId() == id) {
            temp = node;
        }
        //这里离添加!=null的条件，是因为防止返回null会把之前找到的节点覆盖掉
        //向左开始遍历
        if (node.getLeft() != null && temp == null) {
            temp = find(node.getLeft(), id);
        }
        //向右开始遍历
        if (node.getRight() != null && temp == null) {
            temp = find(node.getRight(), id);
        }
        return temp;
    }

    /**
     * 封装查找的函数
     *
     * @param id 要查找的学生id
     * @return 找到就返回学生对象，没有就返回null
     */
    public StudentNode find(int id) {
        if (root == null) {
            return null;
        }
        //从根节点开始寻找
        return find(root, id);
    }

    /**
     * 删除对应id的节点,这里是简单的删除
     * 遇到没有子树的节点，直接删除
     * 如果是有子树的节点，那也直接把节点连同子树一起删除
     *
     * @param node 节点
     * @param id   要删除学生的id
     * @return 删除成功就返回1，否则就是0
     */
    private int delete(StudentNode node, int id) {
        int result = 0;

        if (node.getLeft() != null) {
            if (node.getLeft().getId() == id) {
                node.setLeft(null);
                return 1;
            } else {
                //从左边开始遍历
                result = delete(node.getLeft(), id);
            }
        }
        if (node.getRight() != null && result == 0) {
            if (node.getRight().getId() == id) {
                node.setRight(null);
                return 1;
            } else {
                //从左边开始遍历
                result = delete(node.getRight(), id);
            }
        }
        return result;
    }

    public void delete(int id) {
        if (root == null) {
            System.out.println("当前二叉树为空！");
            return;
        }

        //如果根节点不为空，判断是否是要删除节点
        if (root.getId() == id) {
            //删除根节点
            root = null;
            System.out.println("删除成功");
        } else {
            int result = delete(root, id);
            if (result == 0) {
                System.out.println("查无此人");
            } else {
                System.out.println("删除成功");
            }
        }


    }
}
