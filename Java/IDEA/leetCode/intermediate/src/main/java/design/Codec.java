package design;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author 饮木
 * @Date 2022/7/31 15:55
 * @Description TODO
 */
public class Codec {
    final String SEPARATE = " ";
    final String NULL = "#";

    /**
     * 层序序列化树
     *
     * @param root 树的根节点
     * @return 储存树信息的字符串
     */
    public String serialize(TreeNode root) {
        if (root == null) {
            return "#";
        }
        StringBuilder sb = new StringBuilder();
        //利用队列来进行层序遍历
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode temp;
        while (!queue.isEmpty()) {
            int count = queue.size();
            for (int i = 0; i < count; i++) {
                temp = queue.poll();
                if (temp == null) {
                    sb.append(NULL);
                } else {
                    sb.append(String.valueOf(temp.val));
                    queue.add(temp.left);
                    queue.add(temp.right);
                }
                //节点与节点之间用空格隔开
                sb.append(SEPARATE);
            }
        }
        return sb.toString();
    }

    public TreeNode deserialize(String data) {
        if (data.equals(NULL)) {
            return null;
        }
        String[] split = data.split(SEPARATE);
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(split[0]));
        int splitIndex = 1;
        queue.add(root);
        while (!queue.isEmpty()) {
            String left = split[splitIndex++];
            String right = split[splitIndex++];
            TreeNode temp = queue.poll();
            if (!left.equals(NULL)) {
                temp.left = new TreeNode(Integer.parseInt(left));
                queue.add(temp.left);
            }
            if (!right.equals(NULL)) {
                temp.right = new TreeNode(Integer.parseInt(right));
                queue.add(temp.right);
            }
        }
        return root;
    }
}
