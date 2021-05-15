package leetcode;

/**
 * Created by wuyue on 2021/4/29.
 * 输入：x = 2.00000, n = 10
 * 输出：1024.00000
 * 示例 2：
 * <p>
 * 输入：x = 2.10000, n = 3
 * 输出：9.26100
 * 示例 3：
 * <p>
 * 输入：x = 2.00000, n = -2
 * 输出：0.25000
 * 解释：2-2 = 1/22 = 1/4 = 0.25
 * <p>
 * <p>
 * 提示：
 * <p>
 * -100.0 <x< 100.0
 * -231<= n <=231-1
 * -104 <= xn <= 104
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/powx-n
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *  偏暴力解法
 *  res = res * res 每次为自己的二次方
 *  在不满足二次方的剩余部分使用
 *  res=res*x
 *  补齐
 *
 *  在之前可以对  0 1 -1 做预判
 *
 *  long t = n < 0 ? -1 * (long) n : (long) n
 *   n需要转成long
 *
 *   当-2147483648 以int为单位的时候，乘以-1 ，会变为1
 *
 *   用时比较久 大部分时候会出现超时的情况
 *
 */
public class Num050 {
    public static void main(String[] args) {

        Num050 num050 = new Num050();
        System.out.println(num050.myPow(-1.00000, -2147483648));
    }

    public double myPow(double x, int n) {
        if (n == 0)
            return 1;
        if (x==1)
            return x;
        if (x==-1)
            return n<0?-1*x :x;
        double res = x;
        long time = 2;
        long t = n < 0 ? -1 * (long) n : (long) n;
        while (time < t ) {
            res = res * res;
            time = time * 2;
        }
        // 补齐，在指数的角度，每次加1
        time=time/2;
        while (time<t){
            res=res*x;
            time++;
        }
        if (n < 0) {
            res = 1 / res;
        }
        return res;
    }
}
