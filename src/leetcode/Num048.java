package leetcode;

/**
 * Created by wuyue on 2021/3/17.
 * 给定一个 n×n 的二维矩阵matrix 表示一个图像。请你将图像顺时针旋转 90 度。
 *
 * 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotate-image
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * n x n的矩阵
 * 将某一行转成对应列 ，第一行变成第n列
 *
 *  下标变换 （i，j） 换成 （j,n-i-1）
 *  {1, 2, 3, 4}
 *  {5, 6, 7, 8}
 *  {9,10,11, 12}
 *  {13,14,15,16}
 *
 *  1->4,4->16 ,16->13 ,13->1 每一步换四个点的位置
 *  遍历一行，就相当于 将其转了一圈，第一圈互相交换位置
 *  {1, 2, 3,  4}
 *  {5,        8}
 *  {9,        12}
 *  {13,14,15,16}
 *
 *  第二圈：
 *  {          }
 *  {  6, 7    }
 *  {  10,11  }
 *  {         }
 *
 *  其实只需要 遍历 n/2 行内容 ，遍历n行会重复旋转 ，n为奇数时，最中间只有一个数，不需旋转
 *
 *  for (int i = 0; i < maxLen/2; i++)
 *  第一层循环  确定旋转层数层数
 *
 *  for (int j = i; j < maxLen - i-1; j++)
 *   maxLen - i-1 这里需要注意
 *
 *   1, 2, 3,  4
 *
 *   只要走到 n-i-1就行 ，即到 3 而不是到4 ，因为在第一步的时候，1已经被换到4的位置
 *   上了，如果再换就多了一次轮换
 */
public class Num048 {
    public static void main(String[] args) {
        Num048 num048 = new Num048();
        int[][] matrix = {{1, 2, 3,4}, {5,6,7,8}, {9,10,11,12},{13,14,15,16}};
//        int[][] matrix = {{1, 2, 3}, {4,5,6}, {7,8,9}};
        num048.rotate(matrix);
        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

    public void rotate(int[][] matrix) {
        int maxLen=matrix[0].length;
        int len = matrix[0].length - 1;
        //  见注释
        for (int i = 0; i < maxLen/2; i++) {
            //  见注释
            for (int j = i; j < maxLen - i-1; j++) {
                int last = matrix[i][j];
                int next_i = j;
                int next_j = len-i;
                for (int k = 0; k < 4; k++) {
                    int temp = matrix[next_i][next_j];
                    matrix[next_i][next_j] = last;
                    // 这里交换需要保存next_i的值，
                    // 因为先next_i = next_j;后
                    // 直接next_j = len -next_i实际next_i已经变了
                    int temp_i = next_i;
                    next_i = next_j;
                    next_j = len - temp_i;
                    last = temp;
                }
            }
        }
    }
}
