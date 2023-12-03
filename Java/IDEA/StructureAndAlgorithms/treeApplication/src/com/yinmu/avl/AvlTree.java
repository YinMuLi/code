package com.yinmu.avl;

/**
 * @author 饮木
 * @Date 2022/6/19
 * @Description 平衡二叉树
 */
public class AvlTree {
    /**
     * 根节点
     */
    private Node root;

    public AvlTree(Node root) {
        this.root = root;
    }

    /**
     * 根据数组创建二叉排序树
     *
     * @param array 数组
     */
    public AvlTree(int[] array) {
        if (array == null || array.length == 0) {
            System.out.println("当前数组不可创建二叉排序树");
            return;
        }
        //创建根节点
        setRoot(new Node(array[0]));
        for (int i = 1; i < array.length; i++) {
            add(new Node(array[i]));
        }
    }

    public AvlTree() {
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    /**
     * 向二叉树中添加新的节点
     */
    public void add(Node newNode) {
        if (root == null) {
            System.out.println("请先设置根节点");
            return;
        }
        //从根节点开始
        add(root, newNode);
    }

    /**
     * 递归添加新节点
     *
     * @param node 要添加的节点
     */
    private void add(Node node, Node newNode) {
        //新节点的权值大就往右添加
        if (newNode.getValue() >= node.getValue()) {
            if (node.getRight() == null) {
                node.setRight(newNode);
            } else {
                //如果当前的节点的右节点不为空，向下递归
                add(node.getRight(), newNode);
            }
        } else {
            //新的节点权值小，就往左添加
            if (node.getLeft() == null) {
                node.setLeft(newNode);
            } else {
                add(node.getLeft(), newNode);
            }
        }
        //在节点添加完毕后判断是否需要左选装还是右旋转
        //左旋转
        if (getRightHeight() - getLeftHeight() > 1) {
            //如果当前根节点的右子树的左子树的高度大于右子树的高度
            //要先对根节点的右子树进行右旋转
            if (getLeftHeight(root.getRight()) > getRightHeight(root.getRight())) {
                rightRotate(root.getRight());
            }
            leftRotate(root);
            //防止意料之外的bug
            return;
        }
        //右旋转
        if (getLeftHeight() - getRightHeight() > 1) {
            //更节点的左子树的右子树大于左子树
            //对根节点的左子树进行左旋转
            if (getLeftHeight(root.getLeft()) > getRightHeight(root.getLeft())) {
                rightRotate(root.getLeft());
            }
            rightRotate(root);
        }
    }

    /**
     * 中序遍历二叉树，先左后中，最后是右
     */
    public void infixErgodic() {
        if (root == null) {
            System.out.println("当前二叉树的根节点为空");
            return;
        }
        infixErgodic(root);
    }

    private void infixErgodic(Node node) {
        if (node.getLeft() != null) {
            infixErgodic(node.getLeft());
        }
        System.out.println(node);
        if (node.getRight() != null) {
            infixErgodic(node.getRight());
        }
    }

    /**
     * 返回对应权值的父节点
     *
     * @param value 节点的权值
     * @return 找到就返回节点对象，否者返回null
     */
    private Node getParent(Node node, int value) {
        //存储找到的节点
        Node temp = null;
        //左节点不为空
        if (node.getLeft() != null && node.getValue() > value) {
            if (node.getLeft().getValue() == value) {
                //返回父节点
                temp = node;
            } else {
                //开始递归查找
                temp = getParent(node.getLeft(), value);
            }
        }
        //右节点不为空
        //temp==null防止重复查找
        if (node.getRight() != null && node.getValue() <= value && temp == null) {
            if (node.getRight().getValue() == value) {
                //返回父节点
                temp = node;
            } else {
                //开始递归查找
                temp = getParent(node.getRight(), value);
            }
        }
        return temp;
    }

    /**
     * @param value 查找节点的权值
     * @return 如果这个节点是root节点，就返回root，不是就返回对应权值节点的父节点，没找到就返回null
     */
    public Node getParent(int value) {
        if (root == null) {
            System.out.println("当前根为空节点");
            return null;
        }
        if (root.getValue() == value) {
            //返回根节点
            return root;
        } else {
            return getParent(root, value);
        }
    }

    /**
     * 根据节点的权值获取对应的节点
     *
     * @param value 要获取节点的权值
     * @return 找到返回节点对象没有就返回null
     */
    private Node get(Node node, int value) {
        Node temp = null;
        if (node.getValue() == value) {
            temp = node;
        }
        //没找到，向左递归
        if (node.getLeft() != null && temp == null) {
            temp = get(node.getLeft(), value);
        }
        //没找到，向右递归
        if (node.getRight() != null && temp == null) {
            temp = get(node.getRight(), value);
        }
        return temp;
    }

    /**
     * 据节点的权值获取对应的节点
     *
     * @param value 获取节点的权值
     * @return 找到返回节点对象没有就返回null
     */
    public Node get(int value) {
        if (root == null) {
            return null;
        }
        return get(root, value);
    }

    /**
     * 删除指定节点
     *
     * @param value 要删除节点的权值
     */
    public void delete(int value) {
        if (root == null) {
            System.out.println("二叉树根节点为空");
            return;
        }
        //父节点
        Node parent = getParent(value);
        //目标节点
        Node target = get(value);
        if (parent == null || target == null) {
            //父节点或者目标节点为空就直接返回
            return;
        }
        //第一种情况，删除的节点是叶子节点
        //判断目标节点是否为叶子节点
        if (target.getLeft() == null && target.getRight() == null) {
            //如果目标节点是root节点
            if (target == root) {
                setRoot(null);
                return;
            }
            if (parent.getLeft() == target) {
                //目标节点是父节点的左子节点
                parent.setLeft(null);
            } else {

                //目标节点是父节点的右子节点
                parent.setRight(null);
            }
            return;
        }
        //第二种情况，目标节点有左节点，没有右节点
        if (target.getLeft() != null && target.getRight() == null) {
            //如果该节点是root节点
            if (target == root) {
                setRoot(target.getLeft());
                return;
            }
            if (parent.getLeft() == target) {
                parent.setLeft(target.getLeft());
            } else {
                parent.setRight(target.getLeft());
            }
            return;
        }
        //第三种情况，目标节点有右节点，没有左节点
        if (target.getRight() != null && target.getLeft() == null) {
            //如果该节点是root节点
            if (target == root) {
                setRoot(target.getRight());
                return;
            }
            if (parent.getLeft() == target) {
                parent.setLeft(target.getRight());
            } else {
                parent.setRight(target.getRight());
            }
            return;
        }
        //第四种情况，目标节点有左右节点。跟是否是root节点没有关系
        if (target.getLeft() != null && target.getRight() != null) {
            //从当前目标节点开始，向左子节点寻找最小值
            Node temp = getMinNode(target);
            //如果目标节点是root节点
            if (target == root) {
                setRoot(temp);
            } else {
                //不是root节点
                if (parent.getLeft() == target) {
                    //如果目标节点是左子节点
                    parent.setLeft(temp);
                } else {
                    //如果目标节点是右子节点
                    parent.setRight(temp);
                }
            }
            temp.setLeft(target.getLeft());
            temp.setRight(target.getRight());
        }
    }

    /**
     * 以当前节点为根节点，向左子节点寻找最小值
     *
     * @param node 根节点
     * @return 返回当前节点的子节点中的最小节点
     */
    private Node getMinNode(Node node) {
        Node temp = node;
        while (temp.getLeft() != null) {
            temp = temp.getLeft();
        }
        //跳出循环temp即使最小节点
        //先在二叉树中删除temp节点
        delete(temp.getValue());
        return temp;
    }

    /**
     * 获得树的高度
     *
     * @return 返回整个树的高度
     */
    private int getTreeHeight(Node node) {
        if (node == null) {
            return 0;
        }
        //左边高度
        int leftHeight = getTreeHeight(node.getLeft());
        //右边高度
        int rightHeight = getTreeHeight(node.getRight());
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public int getTreeHeight() {
        //从跟节点开始
        return getTreeHeight(root);
    }

    public int getRightHeight() {
        return getRightHeight(root);
    }

    public int getLeftHeight() {
        return getLeftHeight(root);
    }

    /**
     * @return 返回左子树的高度
     */
    private int getLeftHeight(Node node) {
        if (node == null) {
            return 0;
        }
        return getTreeHeight(node.getLeft());
    }

    /**
     * @return 返回右子树的高度
     */
    private int getRightHeight(Node node) {
        if (node == null) {
            return 0;
        }
        return getTreeHeight(node.getRight());
    }

    /**
     * 当右子树过长，进行左旋转
     */
    private void leftRotate(Node node) {
        //以当前根节点的值创建新的节点
        Node newNode = new Node(node.getValue());
        //把新的节点的左子树设置成为当前节点的左子树
        newNode.setLeft(node.getLeft());
        //把新的节点的右子树设置为当前节点的右子树的左子树
        newNode.setRight(node.getRight().getLeft());
        //把当前节点的值替换为右子节点的值
        node.setValue(node.getRight().getValue());
        //把当前节点的右子树设置为当前节点的右子树的右子树
        node.setRight(node.getRight().getRight());
        //把当前节点的左子树设置为新的节点
        node.setLeft(newNode);
        //原来的右子节点会被垃圾回收机制给回收掉
    }

    /**
     * 当左子树过长的时候，进行右旋转
     */
    private void rightRotate(Node node) {
        //以当前节点的值创建新的节点
        Node newNode = new Node(node.getValue());
        //令新节点的右子树设置为当前节点的右子树
        newNode.setRight(node.getRight());
        //令新节点的左子树设置为当前节点的左子树的右节点
        newNode.setLeft(node.getLeft().getRight());
        //设置当前节点的值为左子树的值
        node.setValue(node.getLeft().getValue());
        //令当前节点的左子树设置为当前节点的左子树的左子树
        node.setLeft(node.getLeft().getLeft());
        //令当前节点的右子树设置为新节点
        node.setRight(newNode);
    }
}
