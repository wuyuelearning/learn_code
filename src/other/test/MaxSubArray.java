package other.test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by wuyue on 2021/3/8.
 */
public class MaxSubArray {
    public static void main(String[] args) {
        int[] a= {1,2,3};
        int maxvalue =a[0];  //最大和
        int add=0;  //第0-i个元素的和
        int j=0;  //最大下标
        for (int i = 0; i < a.length; i++) {
            add=add+a[i];
            if (add>maxvalue) {
                maxvalue=add;
                j=i;
            }
        }
//        System.out.println("最大和"+maxvalue);
//        System.out.println("最大下标"+j);
//        System.out.println(fun1(a));
//        System.out.println(index_i);
//        System.out.println(index_j);


        long start =System.currentTimeMillis();
        List<List<Integer>> permute = permute(a);
        long end =System.currentTimeMillis();

//        System.out.println((end-start));

        permute.forEach(item->{
            for (Integer integer : item) {
                System.out.print(integer+",");
            }
            System.out.println();
        });

//        long start2 =System.currentTimeMillis();
//        List<List<Integer>> permute2 = permute2(a);
//        long end2 =System.currentTimeMillis();
//
//        System.out.println((end2-start2));
//
//        permute2.forEach(item->{
//            for (Integer integer : item) {
//                System.out.print(integer+",");
//            }
//            System.out.println();
//        });

    }


    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        List<Integer> output = new ArrayList<Integer>();
        for (int num : nums) {
            output.add(num);
        }

        // n个数，就是第一步有n个方向，
        // 以num[0]开始第一步，或以nums[1]开始第一步等
        int n = nums.length;
        backtrack(n, output, res, 0);
        return res;
    }

    // 是dfs的思想
    // first：走到第几步，树的第几层
    public static void backtrack(int n, List<Integer> output, List<List<Integer>> res, int first) {
        // 所有数都填完了，如果以树的形式理解，就是到达叶子结点
        // 把路径，即一组排序后的数组，存入res中，
        // 并没有return，到达叶子结点first是等于n的，进入不了下面的循环
        // 执行到first+1 为3的那一层之后的最后，自然会返回上一层，加不加都一样
        if (first == n) {
            res.add(new ArrayList<>(output));
        }
        // 分n个方向走,从first开始到n（不是i等于0开始）
        // 表示从first到n还有几步或几个方向
        // n个方向，按顺序，每一次一直按一个方向走一步，直到走不了了
        // 返回上一层，选上一层没有走过的下一个方向，
        // 往下走一步，在按顺序，从第一个方向走
        for (int i = first; i < n; i++) {
            // 动态维护数组，在原来的数组上改动，移动位置，就是在排序
            Collections.swap(output, first, i);
            // 继续递归填下一个数
            backtrack(n, output, res, first + 1);
            // 以树的形式理解，是返回上一层
            // 回溯，撤销操作
            Collections.swap(output, first, i);
        }
    }



    public static List<List<Integer>> permute2(int[] nums) {
        int len =nums.length;
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (len ==0){
            return res;
        }

        LinkedList<Integer> path = new LinkedList<>();
        boolean[] used =new boolean[len];
        dfs(nums,len,0,path,used,res);
        return res;
    }

    private static void dfs(int[] nums, int len, int depth, LinkedList<Integer> path, boolean[] used, List<List<Integer>> res) {
        if (depth==len){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i=0;i<len;i++){
            if (used[i]){ //  已经使用过
                continue;
            }
            path.addLast(nums[i]);
            used[i]=true;
            dfs(nums,len,depth+1,path,used,res);
            // 回溯
            path.removeLast(); // 将已经添加的末尾移除
            used[i]=false; // 走过的层数，标记为没有走过
        }
    }


    static int index_j =0;
    static int index_i=0;

    private static int fun1(int[] num){
        int max =Integer.MIN_VALUE;
        int temp =num[0];

        for (int i =0;i<num.length;i++){
            if (temp<=0){
                temp=num[i];
                // 最大子数组的左边界
                index_i=i;
            } else {
                temp+=num[i];
            }
            if (temp>max){
                max =temp;
                // 最大子数组的右边界
                index_j=i;
            }
        }
        return max;
    }

}
