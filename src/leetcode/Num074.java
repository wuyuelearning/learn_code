package leetcode;

/**
 * @Author: wuyue27
 * @Date: 2021/7/2 14:30
 * @Description:
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 *
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 *
 * 来源：力扣（LeetCode）
 *
 * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
 * 输出：true
 *
 * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
 * 输出：false
 *
 * 提示：
 *
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 100
 * -104 <= matrix[i][j], target <= 104
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-a-2d-matrix
 *
 * 思路：
 *  两个指针，一个从a（0,0） 一个从b（m ,n）
 *   一点一点往里面缩小范围
 *   a向下移动 b向上移动
 *
 *
 **/
public class Num074 {
    public static void main(String[] args) {
        Num074 num074 =new Num074();
        int[][] matrix ={{1,4,5,7},{10,11,16,20},{23,30,34,60}};
        System.out.println(num074.searchMatrix(matrix, 3));
    }


    public boolean searchMatrix(int[][] matrix, int target) {
        int a_i=0;
        int b_i=matrix.length-1;
        int b_j =matrix[0].length-1;
        for (int i =0;i<matrix.length;i++){
            if (matrix[a_i][0]<=target){
                a_i++;
            }
            if (matrix[b_i][b_j]>=target){
                b_i--;
            }
        }

        // 各自往回退一步
        a_i--;
        b_i++;
        if ( a_i == b_i && matrix[a_i][0]<=target && matrix[b_i][b_j]>=target){
            for (int i=0;i<matrix[0].length;i++){
                if (matrix[a_i][i] == target){
                    return true;
                }
            }
        }
        return false;
    }
}
