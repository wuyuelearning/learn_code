package leetcode;

/**
 * Created by wuyue on 2021/3/19.
 *
 *给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。

 *示例 1:

 *输入: num1 = "2", num2 = "3"
 *输出: "6"
 *示例 2:

 *输入: num1 = "123", num2 = "456"
 *输出: "56088"
 *说明：

 *num1 和 num2 的长度小于110。
 *num1 和 num2 只包含数字 0-9。
 * num1 和 num2 均不以零开头，除非是数字 0 本身。
 * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 *
 * 通过加分，3x 14 表示 14+ 14 + 14 -> 第一步 14+14 =28 , 再 28+14  累加3-1次
 *  但是 14+14 =28 , 再 28+14 比较慢
 *  19 * 45
 *  可以 45 +45 =a 之后 a+a =b ，b+b=c
 *  以 1 2 4 8 的步长累加，但是 累加次数不好确定
 *  什么时候停下是个问题 加到 16 ，表示前16个45相加，再但加 3次45
 *  如果很大的累加次数，2的幂次步长停下时间，都是字符串，不能直接数值比较，又要写判断停下来的方法，剩余的步数简单的累加
 *  而且，如果剩余的也很大，就也很耗时
 */
public class Num043 {
    public static void main(String[] args) {
        Num043 num043 = new Num043();
//        String multiply = num043.multiply("1231", "2345");
//        System.out.println(multiply);

//        System.out.println(num043.add(new StringBuilder("199").reverse().toString(), new StringBuilder("132").reverse().toString()));

        long l = System.currentTimeMillis();
        System.out.println(num043.multiply("123456789", "987654321"));
        long s =System.currentTimeMillis();
        System.out.println( s-l );
        System.out.println( (s-l)/1000 );
    }

    private String multiply(String num1, String num2) {
        StringBuilder res = new StringBuilder("0");
        if ("0".equals(num1) || "0".equals(num2))
            return res.toString();

        String num = "1";
        if (num1.length() < num2.length()) {
            res = new StringBuilder(num2).reverse();
            String temp = new StringBuilder(num2).reverse().toString();
            while (!num.equals(num1)) {
                num = add1(num);
                res = add(temp, res.toString());
            }
        } else {
            res = new StringBuilder(num1).reverse();
            String temp = new StringBuilder(num1).reverse().toString();
            while (!num.equals(num2)) {
                num = add1(num);
                res = add(temp, res.toString());
            }
        }
        return res.reverse().toString();
    }

    private String add1(String a1) {
        StringBuilder stringBuilder = new StringBuilder();
        int len = a1.length();
        int index = 0;
        int temp = 0;
        StringBuilder n1 = new StringBuilder(a1).reverse();
        int i1 = n1.charAt(index) - '0';
        int i = i1 + temp + 1;
        if (i >= 10) {
            temp = 1;
            stringBuilder.append(i - 10);
        } else {
            temp = 0;
            stringBuilder.append(i);
        }
        index++;

        while (index < len) {
            i1 = n1.charAt(index) - '0';
            i = i1 + temp;
            if (i >= 10) {
                temp = 1;
                stringBuilder.append(i - 10);
            } else {
                temp = 0;
                stringBuilder.append(i);
            }
            index++;
        }
        if (temp == 1) {
            stringBuilder.append("1");
        }
        return stringBuilder.reverse().toString();
    }

    private StringBuilder add(String a1, String a2) {
        StringBuilder n1 = new StringBuilder(a1);
        StringBuilder n2 = new StringBuilder(a2);
        int temp = 0;
        int len1 = n1.length();
        int len2 = n2.length();
        int len = Math.min(len1, len2);
        int index = 0;
        StringBuilder stringBuilder = new StringBuilder();
        while (index < len) {
            int i1 = n1.charAt(index) - '0';
            int i2 = n2.charAt(index) - '0';
            int i = i1 + i2 + temp;
            if (i >= 10) {
                temp = 1;
                stringBuilder.append(i - 10);
            } else {
                temp = 0;
                stringBuilder.append(i);
            }
            index++;
        }
        len = Math.max(len1, len2);
        StringBuilder n;
        if (len1 > len2) {
            n = n1;
        } else {
            n = n2;
        }
        while (index < len) {
            int i1 = n.charAt(index) - '0';
            int i = i1 + temp;
            if (i >= 10) {
                temp = 1;
                stringBuilder.append(i - 10);
            } else {
                temp = 0;
                stringBuilder.append(i);
            }
            index++;
        }
        if (temp == 1) {
            stringBuilder.append("1");
        }
        return stringBuilder;
    }
}
