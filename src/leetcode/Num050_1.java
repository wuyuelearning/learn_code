package leetcode;

/**
 * Created by wuyue on 2021/4/30.
 *
 * x（64） 表示x的64次方
 *
 * x(1)->x(2)->x(4)->x(8)->x(16)->x(32)->x(64)
 * 每一次都是乘以之前的值
 *
 *  x（77）
 *  x(1)->x(2)->x(4)->x(9)->x(19)->x(38)->x(77)
 *
 *  有的地方 x(4)*x(4)*x 有的 x(2)*x(2)
 *  如果判断，从左到右不好判断 ，应该从右到左 77/2 商为38 余1
 *  所以从38 到77 是要 x(38)*x(38)*x 多乘以一个x
 *
 *  38/2 商为19 余数0
 *  所以从19 到38 是 x(19)*x(19)
 *
 *
 * 什么时候
 */
public class Num050_1 {
    public static void main(String[] args) {
        Num050_1 num050_1 = new Num050_1();
        System.out.println(num050_1.myPow(-1.00000, -2147483648));



    }

    public double myPow(double x, int n) {
        long nn = n;
        double res = n < 0 ? 1 / quickMul(x, -1 * nn) : quickMul(x, nn);
        return res;
    }

    private double quickMul(double x, long n) {
        if (n == 0)
            return 1.0;
        double res =quickMul(x,n/2);
        if (n%2 ==0){
            return res*res;
        } else {
            return res*res*x;
        }
    }

    long fun(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        return fun(n - 1) + fun(n - 2);
    }

    long fun2(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;

        int time = 1;
        long last = 0;

        long res = 1;
        while (time < n) {
            long temp = res;
            res = res + last;
            last = temp;
            time++;
        }
        return res;
    }

}
