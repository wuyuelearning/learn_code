package leetcode;

/**
 *      实现 int sqrt(int x) 函数。
 *
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 *
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 *
 * 示例 1:
 *
 * 输入: 4
 * 输出: 2
 * 示例 2:
 *
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 *      由于返回类型是整数，小数部分将被舍去。
 *  思路： 看了解题之后得知
 *   a*a <=x < =(a+1)(a+1)  时间会很长
 */
public class Num069 {
    public static void main(String[] args) {
        Num069 num069 =new Num069();
        System.out.println(num069.mySqrt(Integer.MAX_VALUE-1));
        System.out.println((Integer.MAX_VALUE/2) + (Integer.MAX_VALUE/2));
        System.out.println((Integer.MAX_VALUE));
    }
    public int mySqrt(int x) {
        for (int i=0;i<Integer.MAX_VALUE/2;i++){
            if (i*i == x)
                return i;
            if (i*i< x && x<(long)(i+1)*(i+1)){
                return i;
            }
        }
        return -1;
    }
}
