package other.test;

/**
 *  通过前序，中序构建搜索二叉树
 */
public class rebuildTree {
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(8);

        n1.leftNode = n2;
        n2.leftNode = n4;
        n4.rightNode = n7;
        n1.rightNode = n3;
        n3.leftNode = n5;
        n3.rightNode = n6;
        n6.leftNode = n8;

        rebuildTree test6 = new rebuildTree();
        test6.fun1(n1);
        System.out.println();
        test6.fun2(n1);
        System.out.println();
        test6.fun3(n1);
        System.out.println();

        int[] preNode = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] midNode = {4, 7, 2, 1, 5, 3, 8, 6};
        TreeNode root = test6.fun4(preNode, midNode);

        test6.fun1(root);

    }

    private TreeNode fun4(int[] preNode, int[] midNode) {
        if (preNode == null || midNode == null || preNode.length != midNode.length)
            return null;
        return fun5(preNode, midNode, 0, preNode.length - 1, 0, midNode.length - 1);
    }

    private TreeNode fun5(int[] preNode, int[] midNode, int preStart, int preEnd, int midStart, int midEnd) {
        if (preStart > preEnd || midStart > midEnd)
            return null;
        TreeNode node = new TreeNode(preNode[preStart]);
        node.leftNode = null;
        node.rightNode = null;
        // 在中序遍历数组找出前序遍历的
        int rootInorder = midStart;
        for (int i = midStart; i <= midEnd; i++) {
            if (midNode[i] == preNode[preStart])
                rootInorder = i;
        }
        // rootInorder - midStart 为中序遍历数组的的左子树长度
        // preStart + 1, preStart + rootInorder - midStart为前序遍历数组中左子树的范围
        // midStart, rootInorder - 1 为中序遍历中的左子树范围
        node.leftNode = fun5(preNode, midNode, preStart + 1, preStart + rootInorder - midStart, midStart, rootInorder - 1);
        node.rightNode = fun5(preNode, midNode, preStart + rootInorder - midStart + 1, preEnd, rootInorder + 1, midEnd);
        return node;
    }

    // 前序遍历，先访问根节点
    private void fun1(TreeNode node) {
        if (node == null)
            return;
        System.out.print(node.value + ",");
        fun1(node.leftNode);
        fun1(node.rightNode);
    }

    // 中序遍历，先访问左子节点
    private void fun2(TreeNode node) {
        if (node == null)
            return;
        fun2(node.leftNode);
        System.out.print(node.value + ",");
        fun2(node.rightNode);
    }

    // 后序遍历，左-右-根
    private void fun3(TreeNode node) {
        if (node == null)
            return;
        fun3(node.leftNode);
        fun3(node.rightNode);
        System.out.print(node.value + ",");
    }
}


class TreeNode {
    TreeNode(int _val) {
        this.value = _val;
    }

    int value;
    TreeNode leftNode;
    TreeNode rightNode;
}
