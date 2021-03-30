package leetcode;

/**
 * Created by wuyue on 2021/3/6.
 *  官方解法
 *  在长度为n的数组中，最佳出现的方式的是 1，2，3，4。。。n
 *  那么缺少的值为n+1
 *  只要这n个数中 ，出现了小于等于0  或大于n的数，或出现了（不论是否在 1 ，2，3，。。。 n内）重复的数字，就有一个原本 1 ，2，3，。。。 n 的数被挤掉
 *  却是的数就是 1，2，3。。。n中的一个
 *
 *
 */
public class Num041 {
    public static void main(String[] args) {
        Num041 num041 =new Num041();
        int[] num ={1,2,3,4};
        num041.firstMissingPositive(num);
    }
    public int firstMissingPositive(int[] nums) {
        if (nums.length==0)
            return 1;



        return 1;
    }
}
