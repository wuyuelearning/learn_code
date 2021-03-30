package other.test;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by wuyue on 2021/3/8.
 */
public class IsTree {
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
//        System.out.println(maxDepth(n1));
//        System.out.println(isBalance(n1));


        print(n1);
        treeReversal(n1);
        System.out.println();
        print(n1);

    }



    private static void print (TreeNode n){
        if (n ==null)
            return;
        print(n.leftNode);
        System.out.print(n.value+", ");
        print(n.rightNode);
    }

    private static void treeReversal(TreeNode node){
        if (node ==null)
            return;
        if (node.leftNode == null && node.rightNode ==null)
            return;

        TreeNode n =node.leftNode;
        node.leftNode = node.rightNode;
        node.rightNode =n;

        treeReversal(node.leftNode);
        treeReversal(node.rightNode);
    }


    public static boolean isBalance(TreeNode node){
        if (node == null) return true;
        return Math.abs(maxDepth(node.leftNode)-maxDepth(node.rightNode)) <=1
                && isBalance(node.leftNode) && isBalance(node.rightNode);
    }

    // dfs
    public static int maxDepth(TreeNode root) {
        if (root==null) return 0;
        return Math.max(maxDepth(root.leftNode),maxDepth(root.rightNode))+1;
    }
    public static int max(TreeNode root){
        if (root ==null )return 0;
        // 使用List
        List<TreeNode> deque =new LinkedList<>();
        deque.add(root);
        int res =0;
        while (!deque.isEmpty()){
            List<TreeNode> temp =new LinkedList<>();
            // 将list中全部遍历一遍，找list中所有节点的子节点
            // deque中存放的是一层节点
            // temp存放的是deque中节点的下一层节点
            for (TreeNode node : deque) {
                if (node.leftNode!=null ) temp.add(node.leftNode);
                if (node.rightNode!=null ) temp.add(node.rightNode);
            }
            deque =temp;
            res++;
        }
        return res;
    }

}
