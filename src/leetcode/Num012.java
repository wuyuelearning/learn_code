/**
 * Created by wuyue on 2019/7/24.
 * <p>
 * 罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
 * <p>
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 * <p>
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 * <p>
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给定一个整数，将其转为罗马数字。输入确保在 1 到 3999 的范围内。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 3
 * 输出: "III"
 * 示例 2:
 * <p>
 * 输入: 4
 * 输出: "IV"
 * 示例 3:
 * <p>
 * 输入: 9
 * 输出: "IX"
 * 示例 4:
 * <p>
 * 输入: 58
 * 输出: "LVIII"
 * 解释: L = 50, V = 5, III = 3.
 * 示例 5:
 * <p>
 * 输入: 1994
 * 输出: "MCMXCIV"
 * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/integer-to-roman
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Num012 {

    public static void main(String[] args) {

        int a = 49;
        System.out.println(intToRoman(a));
    }

    private static String intToRoman(int num) {

        StringBuilder s = new StringBuilder();
        if (num >= 1000) {
            int a = num / 1000;
            while (a > 0) {
                s.append("M");
                a--;
            }
            int n = num / 1000;
            num = num - n * 1000;
        }

        if (num >= 500) {
            if (num >= 900) {
                s.append("CM");
                num = num - 900;
            } else {
                int a = (num - 500) / 100;
                s.append("D");
                while (a > 0) {
                    s.append("C");
                    a--;
                }
                int n = num / 100;
                num = num - n * 100;
            }
        }

        if (num >= 100) {
            if (num >= 400) {
                s.append("CD");
                num = num - 400;

            } else {
                int a = num / 100;
                while (a > 0) {
                    s.append("C");
                    a--;
                }
                int n = num / 100;
                num = num - n * 100;
            }
        }

        if (num >= 50) {
            if (num >= 90) {
                s.append("XC");
                num = num - 90;
            } else {
                int a = (num - 50) / 10;
                s.append("L");
                while (a > 0) {
                    s.append("X");
                    a--;
                }
                int n = num / 10;
                num = num - n * 10;
            }
        }

        if (num >= 10) {
            if (num >= 40) {
                s.append("XL");
                num = num - 40;

            } else {
                int a = num / 10;
                while (a > 0) {
                    s.append("X");
                    a--;
                }
                int n = num / 10;
                num = num - n * 10;
            }
        }

        if (num >= 5) {
            if (num == 9) {
                s.append("IX");
                num = num - 9;
            } else {
                int a = num - 5;
                s.append("V");
                while (a > 0) {
                    s.append("I");
                    a--;
                }
                num = 0;
            }
        }

        if (num >= 1) {
            if (num == 4) {
                s.append("IV");
            } else {
                int a = num;
                while (a > 0) {
                    s.append("I");
                    a--;
                }
            }
        }

        return s.toString();
    }

}
