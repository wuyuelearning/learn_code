/**
 * Created by wuyue on 2021/5/13.
 * 给定一个整数数组 nums，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 示例 1：
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组[4,-1,2,1] 的和最大，为6 。
 * 示例 2：
 *
 * 输入：nums = [1]
 * 输出：1
 * 示例 3：
 *
 * 输入：nums = [0]
 * 输出：0
 * 示例 4：
 *
 * 输入：nums = [-1]
 * 输出：-1
 * 示例 5：
 *
 * 输入：nums = [-100000]
 * 输出：-100000
 *
 *
 * 提示：
 * 1 <= nums.length <= 3 * 104
 * -105 <= nums[i] <= 105
 *
 * 进阶：如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的 分治法 求解。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Num053 {
    public static void main(String[] args) {
        Num053 num053 =new Num053();
        int[] nums ={1};
        System.out.println(num053.maxSubArray(nums));
    }

    private int maxSubArray(int[] nums) {
        int temp =Integer.MIN_VALUE;
        int max =Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (temp<=0){
                temp=nums[i];
            } else {
                temp=temp+nums[i];
            }
            if (temp>max){
                max =temp;
            }
        }
        return max;
    }
}
