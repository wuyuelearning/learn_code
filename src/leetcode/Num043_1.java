package leetcode;

/**
 * Created by wuyue on 2021/3/22.
 *
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 *
 * 示例 1:
 *
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 * 示例 2:
 *
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 * 说明：
 *
 * num1 和 num2 的长度小于110。
 * num1 和 num2 只包含数字 0-9。
 * num1 和 num2 均不以零开头，除非是数字 0 本身。
 * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 *
 * 使用 乘法 分解乘法
 * 321 x 123
 * 先 321 x 3 再分解 3 x1 3x2 3x3 再分别补零 (3x2补一个零：60 ,3x3补两个零：900) 相加 （3+60+900）
 * 以上为 三次单一乘法、补零、三次单一加法
 *
 * 第二位 321 x 2
 * 同上，但是在 2+40+600 =642 之后还需要补零（补零的个数为所在的位置，这里2 在十位，所以补一个零） ，
 * 相当于是 20 与 321 相乘 ，为什么不直接用 20，还是数字长度的限制问题，
 */

public class Num043_1 {
    public static void main(String[] args) {

        Num043_1 num043_1 = new Num043_1();
        long l = System.currentTimeMillis();
        System.out.println(num043_1.multiply("123", "100"));
        long s = System.currentTimeMillis();
        System.out.println(s - l);
        System.out.println((s - l) / 1000);
    }

    private String multiply(String num1, String num2) {
        String res = "0";
        if ("0".equals(num1) || "0".equals(num2))
            return res;
        int len1 = num1.length();
        int len2 = num2.length();
        StringBuilder stringBuilder1 = new StringBuilder(num1).reverse();
        StringBuilder stringBuilder2 = new StringBuilder(num2).reverse();
        int index1 = 0;
        String lastRes = "0";
        while (index1 < len1) {
            int index2 = 0;
            char n1 = stringBuilder1.charAt(index1);
            String last = "0";
            while (index2 < len2) {
                int a = n1 - '0';
                int b = stringBuilder2.charAt(index2) - '0';
                StringBuilder nowTemp = new StringBuilder(String.valueOf(a * b));
                // 补零
                for (int i = 0; i < index2; i++) {
                    nowTemp.append("0");
                }
                String now = nowTemp.toString();
                last = add(now, last).toString();
                index2++;
            }
            StringBuilder lastTemp = new StringBuilder(last);
            // 补零
            for (int i = 0; i < index1; i++) {
                lastTemp.append("0");
            }
            lastRes = add(lastTemp.toString(), lastRes).toString();
            index1++;
        }
        res = lastRes;
        return res;

    }

    private StringBuilder add(String a1, String a2) {
        StringBuilder n1 = new StringBuilder(a1).reverse();
        StringBuilder n2 = new StringBuilder(a2).reverse();
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
        return stringBuilder.reverse();
    }
}
