import java.util.ArrayList;
import java.util.List;

/**
 * Created by wuyue on 2021/5/13.
 * <p>
 * 螺旋矩阵
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 * <p>
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * <p>
 * <p>
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 * <p>
 * 注解1：
 * 分四个方向 ，并且每一轮的，走的方向是固定的 右下左上：
 * 右 ：j++ , 并且<= j_max
 * 下 ：i++ , 并且<= i_max
 * 左 ：j-- , 并且>= j_min
 * 上 : i-- , 并且>= i_min
 *
 * 注解2：
 * 以向右为例：
 *  j++ , 并且<= j_max，向右走
 *  j-- ： j已经到了 j_max 之后j++已经大于 j_max
 *  所以才出了 while (j <= j_max)循环
 *  所以需要将 j--，往回走一步
 *
 */
public class Num054 {
    public static void main(String[] args) {
        Num054 num054 = new Num054();
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
//        int[][] matrix = {{1, 2, 3, 4,5}, {6, 7, 8,9,10}, {11, 12, 13, 14,15}};
//        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12},{13,14,15,16},{17,18,19,20}};
//        int[][] matrix = {{1, 2, 3, 4}};
//        int[][] matrix = {{1}, {2}, {3}, {4},{5},{6},{7},{8},{9},{10}};
        System.out.println(num054.spiralOrder(matrix));
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        // i，j的 边界
        int i_min = 0;
        int j_min = 0;
        int i_max = matrix.length - 1;
        int j_max = matrix[0].length - 1;

        //  每一轮的的起始点
        int i = i_min;
        int j = j_min;
        // 记录哪些位置已经走过，思路类似于dfs
        int[][] temp = new int[matrix.length][matrix[0].length];

        // 通过行和列的最小值，确定旋转轮数
        // 3x4转2轮  1x10转1轮 10x1转1轮
        int round = Math.min(matrix.length, matrix[0].length);
        //  一共需要转几轮
        int time = round % 2 == 0 ? round / 2 : round / 2 + 1;
        int count = 0;  // 记录已经转了几轮了
        while (count < time) { // 注解1
            for (int n = 0; n < 4; n++) {
                // 注解2：
                if (n == 0) {
                    while (j <= j_max ) {
                        if (temp[i][j] == 0){
                            list.add(matrix[i][j]);
                            temp[i][j] = 1;
                        }
                        j++;
                    }
                    j--;
                }
                if (n == 1) {
                    while (i <= i_max) {
                        if (temp[i][j] == 0){
                            list.add(matrix[i][j]);
                            temp[i][j] = 1;
                        }
                        i++;
                    }
                    i--;
                }
                if (n == 2) {
                    while (j >= j_min ) {
                        if (temp[i][j] == 0){
                            list.add(matrix[i][j]);
                            temp[i][j] = 1;
                        }
                        j--;
                    }
                    j++;
                }
                if (n == 3) {
                    while (i >= i_min ) {
                        if (temp[i][j] == 0){
                            list.add(matrix[i][j]);
                            temp[i][j] = 1;
                        }
                        i--;
                    }
                    i++;
                }
            }
            i_max--; //  i最大值往里面移动1位
            i_min++;//   i最小值往里面移动1位
            j_max--; //  j最大值往里面移动1位
            j_min++; //  j最小值往里面移动1位
            i = i_min; // i起始值
            j = j_min; // j起始值
            count++;  // 旋转+1
        }
        return list;
    }
}
